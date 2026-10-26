package phase0.s04_classes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketTest {

    @BeforeEach
    void startFresh() {
        Ticket.resetCount();
    }

    @Test
    void firstTicketIsNumberOne() {
        assertEquals(1, new Ticket("ada").id());
    }

    @Test
    void idsCountUp() {
        Ticket a = new Ticket("ada");
        Ticket b = new Ticket("lin");
        Ticket c = new Ticket("sam");
        assertEquals(1, a.id());
        assertEquals(2, b.id());
        assertEquals(3, c.id());
    }

    @Test
    void anOldTicketKeepsItsId() {
        Ticket a = new Ticket("ada");
        new Ticket("lin");
        new Ticket("sam");
        assertEquals(1, a.id());
    }

    @Test
    void eachTicketKeepsItsOwner() {
        Ticket a = new Ticket("ada");
        Ticket b = new Ticket("lin");
        assertEquals("ada", a.owner());
        assertEquals("lin", b.owner());
    }

    @Test
    void issuedCountsEveryTicket() {
        assertEquals(0, Ticket.issued());
        new Ticket("ada");
        new Ticket("lin");
        new Ticket("sam");
        assertEquals(3, Ticket.issued());
    }

    @Test
    void resetStartsOver() {
        new Ticket("ada");
        new Ticket("lin");
        Ticket.resetCount();
        assertEquals(0, Ticket.issued());
        Ticket t = new Ticket("sam");
        assertEquals(1, t.id());
        assertEquals(1, Ticket.issued());
    }
}
