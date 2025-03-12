package classes;

import com.joanseculi.timejump.TimeJump;
import enums.Subscription;

import java.util.ArrayList;
import java.util.List;

public class NetFilm {
    private String name;
    private List<Client> clients;

    public NetFilm(String name)
    {
        this.name = name;
        clients = new ArrayList<>();
    }

    public boolean signSubscription(Client client)
    {
        if (!clients.contains(client))
            return clients.add(client);

        return false;
    }

    public int countSubscriptions()
    {
        return clients.size();
    }

    public int countSubscriptionsDate(String date)
    {
        int cantClients = 0;
        for (Client client : clients)
        {
            if (TimeJump.compareStringDates(client.getInitialDate(), date) <= 0 &&
                    TimeJump.compareStringDates(client.getEndDate(), date) >= 0)
                cantClients++;
        }

        return cantClients;
    }

    public Client searchClient(String code)
    {
        for (Client client : clients)
            if (client.getCode().equals(code))
                return client;

        return null;
    }

    public long duration(String code)
    {
        for (Client client : clients)
            if (client.getCode().equals(code))
            {
                 return TimeJump.getDays(client.getInitialDate(), client.getEndDate());
            }

        return -1;
    }

    public float getMonthlyFee(String code)
    {
        for (Client client : clients)
            if (client.getCode().equals(code))
            {
                return client.getSubscription().getCost();
            }

        return -1;
    }

    public List<Client> listActiveSubscriptions(String date)
    {
        List<Client> listClient = new ArrayList<>();

        for (Client client : clients)
        {
            if (TimeJump.compareStringDates(client.getInitialDate(), date) <= 0 &&
                    TimeJump.compareStringDates(client.getEndDate(), date) >= 0)
                listClient.add(client);
        }

        return listClient;
    }

    public boolean changeSubscription(String code, String date, Subscription subscription)
    {
        Client client = searchClient(code);

        if (client != null)
            if (listActiveSubscriptions(date).contains(client))
            {
                client.setSubscription(subscription);
                return true;
            }

        return false;
    }

    public boolean endSubscription(String code, String date)
    {
        Client client = searchClient(code);

        if (client != null)
            if (TimeJump.compareStringDates(date, client.getInitialDate()) > 0)
            {
                client.setEndDate(date);
                return true;
            }

        return false;
    }

    public float totalValue(String date)
    {
        List<Client> tempList = listActiveSubscriptions(date);
        float totalCost = 0f;

        for (Client client : tempList)
        {
            totalCost += client.getSubscription().getCost();
        }

        return totalCost;
    }

    @Override
    public String toString()
    {
        String line = "-----------------------------------------------------------------------------------------------------------------------------\n";
        String header = String.format("%-15s%-20s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "CODE", "NAME", "DNI", "SUBSCR.", "INIT", "END", "IBAN", "BANK");
        String body = "";
        for (Client client : clients)
            body += client;

        return line + header + line + body;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
