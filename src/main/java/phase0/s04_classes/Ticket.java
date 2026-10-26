package phase0.s04_classes;

/**
 * Session 04 · Part C: static, one box for the whole class.
 *
 * Every new ticket gets the next id: the first ticket made is 1, then 2, then 3.
 * So the class has to remember one number shared by all tickets, while each ticket
 * remembers its own id and owner.
 *
 * Ticket a = new Ticket("ada");   // a.id() -> 1
 * Ticket b = new Ticket("lin");   // b.id() -> 2
 * a.id();                         // still 1
 * Ticket.issued();                // 2
 *
 * Run just these tests:  mvn -q test -Dtest=TicketTest
 */
public class Ticket {

    // TODO: fields. For each one, decide: one per ticket, or one for the whole class?

    /** A new ticket for owner, with the next id. */
    public Ticket(String owner) {
        throw new UnsupportedOperationException("TODO: implement the Ticket constructor");
    }

    /** This ticket's id. It never changes, however many tickets come after it. */
    public int id() {
        throw new UnsupportedOperationException("TODO: implement id");
    }

    /** Who this ticket belongs to. */
    public String owner() {
        throw new UnsupportedOperationException("TODO: implement owner");
    }

    /**
     * How many tickets have been made since the last resetCount().
     * Called on the class, not on a ticket:  Ticket.issued()
     */
    public static int issued() {
        throw new UnsupportedOperationException("TODO: implement issued");
    }

    /**
     * Start over: the next ticket made gets id 1.
     * The tests call this before each test, because a static field keeps its value for as
     * long as the program runs, from one test into the next.
     */
    public static void resetCount() {
        throw new UnsupportedOperationException("TODO: implement resetCount");
    }
}
