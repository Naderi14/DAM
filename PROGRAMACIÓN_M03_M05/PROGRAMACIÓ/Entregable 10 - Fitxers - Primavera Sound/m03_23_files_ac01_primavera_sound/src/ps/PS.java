package ps;

public class PS {
    private String edition;
    private short year;
    private String date;
    private int assistants;
    private int ticketsDay;
    private float priceDay;
    private int ticketsFullFest;
    private float priceFullFest;
    private int ticketsVips;
    private float priceVip;
    private String headLiners;

    public PS(String edition, short year, String date, int assistants, int ticketsDay, float priceDay, int ticketsFullFest, float priceFullFest, int ticketsVips, float priceVip, String headLiners) {
        this.edition = edition;
        this.year = year;
        this.date = date;
        this.assistants = assistants;
        this.ticketsDay = ticketsDay;
        this.priceDay = priceDay;
        this.ticketsFullFest = ticketsFullFest;
        this.priceFullFest = priceFullFest;
        this.ticketsVips = ticketsVips;
        this.priceVip = priceVip;
        this.headLiners = headLiners;
    }

    public String getEdition() {
        return edition;
    }

    public short getYear() {
        return year;
    }

    public String getDate() {
        return date;
    }

    public int getAssistants() {
        return assistants;
    }

    public int getTicketsDay() {
        return ticketsDay;
    }

    public float getPriceDay() {
        return priceDay;
    }

    public int getTicketsFullFest() {
        return ticketsFullFest;
    }

    public float getPriceFullFest() {
        return priceFullFest;
    }

    public int getTicketsVips() {
        return ticketsVips;
    }

    public float getPriceVip() {
        return priceVip;
    }

    public String getHeadLiners() {
        return headLiners;
    }

    @Override
    public String toString()
    {
        return String.format("PS:[EDITION:%s YEAR:%s DATE:%s ASSISTANTS:%s TICKETS:%s PRICE:%s TCKFULLFEST:%s PRICEFULLFEST:%s TICKETSVIP:%s PRICEVIP:%s\n\tHEADLINERS:%s]",
                edition, year, date, assistants, ticketsDay, priceDay, ticketsFullFest, priceFullFest, ticketsVips, priceVip, headLiners);
    }
}
