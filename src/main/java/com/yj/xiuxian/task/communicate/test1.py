def action_compute_amortization(self):
    """This automatically create the installment the employee need to pay to
    company based on payment start date and the no of installments.
        """
    for rec in self:
        rec.amortization_lines.unlink()
        date_start = rec.date_from
        days_in_a_year = rec.coverage_term
        payment_freq = rec.premium_frequency
        frequency : dict = {
            'monthly':round(days_in_a_year/30),
            'quarterly': round(days_in_a_year/90),
            'biannually': round(days_in_a_year/182),
            'yearly': round(days_in_a_year/days_in_a_year)
        }
        term = frequency.get(payment_freq,days_in_a_year)
        amount = rec.policy_risk_ids.cover_ids.premium_currency
        for i in range(1,days_in_a_year + 1):
            while term > 0:
                payment_date = date_start
                if payment_freq == "monthly":
                    payment_date = date_utils.add(date_start, days=30)
                elif payment_freq == "quarterly":
                    payment_date = date_utils.add(date_start, days=90)
                elif payment_freq == "biannually":
                    payment_date = date_utils.add(date_start, days=182)
                elif payment_freq == "yearly":
                    payment_date = date_start
                else:
                    payment_date = date_utils.add(date_start, hours=24)
                self.env['epgi.policy.amortization'].create({
                    'payment_date': payment_date,
                    'amount': amount,
                    'insured_id': rec.insured_id.id,
                    'policy_id': rec.id})
                term -= 1
    return True