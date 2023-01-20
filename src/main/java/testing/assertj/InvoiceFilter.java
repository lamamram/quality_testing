package testing.assertj;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class InvoiceFilter {
    private final IssuedInvoices issuedInvoices;

    public InvoiceFilter (IssuedInvoices issuedInvoices) {
        this.issuedInvoices = issuedInvoices;
    }

    public List<Invoice> lowValueInvoices() {
        return issuedInvoices.all().stream()
                .filter(invoice -> invoice.value < 100)
                .collect(toList());
    }
}
