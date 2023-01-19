package testing.tests.assertj;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assume.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import testing.assertj.Invoice;
import testing.assertj.InvoiceFilter;
import testing.assertj.IssuedInvoices;

class InvoiceFilterTest {

    private final IssuedInvoices issuedInvoices = mock(IssuedInvoices.class);
    private final InvoiceFilter filter = new InvoiceFilter(issuedInvoices);

    @Test
    void filterInvoices() {
        final var mauricio = new Invoice("Mauricio", 20);
        final var steve = new Invoice("Steve", 99);
        final var arie = new Invoice("Arie", 300);

        when(issuedInvoices.all()).thenReturn(asList(mauricio, arie, steve));
        List<Invoice> filtered = filter.lowValueInvoices();
        // condition pour que le test soit exécuté
        assumeTrue(filtered.size() > 5);
        assertThat(filtered).containsExactlyInAnyOrder(mauricio, steve);
    }

}
