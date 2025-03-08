import classes.*;
import enums.Subscription;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NetFilmMain {
    private static final Scanner SC = new Scanner(System.in);
    private static final NetFilm netFilm = new NetFilm("NETFILM");
    private static Bank[] banks;

    public static void main(String[] args) {
        //Instantiate Banks
        System.out.println("Instantiate Banks");
        Bank freeBank = new Bank("FreeBank", "FREEMMYES");
        System.out.println(freeBank.toString());
        Bank coolBank = new Bank("CoolBank", "COOLSSES");
        System.out.println(freeBank.toString());
        banks = new Bank[]{freeBank, coolBank};

        //Instantiate clients
        System.out.println("Instantiate Clients");
        Client cl1 = new Client("Kate Winslet", "11111111A", Subscription.BASIC_ADVERTS, "01/01/2010", "31/12/2022", "ES001111", freeBank);
        Client cl2 = new Client("Timothée Chalamet", "22222222A", Subscription.BASIC, "01/02/2000", "28/02/2022", "ES002222", freeBank);
        Client cl3 = new Client("Viola Davis", "33333333A", Subscription.STANDARD, "01/01/2000", "31/01/2000", "ES003333", freeBank);
        Client cl4 = new Client("Chris Evans", "44444444A", Subscription.PREMIUM, "01/03/2001", "30/03/2001", "ES004444", freeBank);
        Client cl5 = new Client("Robert Downey Jr", "55555555A", Subscription.BASIC, "01/01/2021", "ES005555", freeBank);
        Client cl6 = new Client("Jennifer Lawrence", "66666666A", Subscription.BASIC, "01/01/2020", "ES006666", freeBank);
        Client cl7 = new Client("Channing Tatum", "77777777A", Subscription.STANDARD, "01/03/2000", "ES007777", coolBank);
        Client cl8 = new Client("Johnny Depp", "88888888A", Subscription.PREMIUM, "ES008888", coolBank);
        Client cl9 = new Client("Jared Leto", "99999999A", Subscription.PREMIUM, "ES009999", coolBank);
        Client cl10 = new Client("Kate Winslet", "00000000A", Subscription.BASIC_ADVERTS, "ES009999", coolBank);

        //Two clients with same dni
        Client cl11 = new Client("Cate Blanchett", "99999999A", Subscription.BASIC, "ES009999", freeBank);
        Client cl12 = new Client("Audrey Hepburn", "00000000A", Subscription.BASIC, "01/01/2000", "ES009999", freeBank);

        System.out.println("Print Clients");
        System.out.println(cl1.toString());
        System.out.println(cl2.toString());
        System.out.println(cl3.toString());
        System.out.println(cl4.toString());
        System.out.println(cl5.toString());
        System.out.println(cl6.toString());
        System.out.println(cl7.toString());
        System.out.println(cl8.toString());
        System.out.println(cl9.toString());
        System.out.println(cl10.toString());
        System.out.println(cl11.toString());  //Duplicated dni
        System.out.println(cl12.toString());  //Duplicated dni


        System.out.println("Sign Subscriptions");
        System.out.println(netFilm.signSubscription(cl1));
        System.out.println(netFilm.signSubscription(cl2));
        System.out.println(netFilm.signSubscription(cl3));
        System.out.println(netFilm.signSubscription(cl4));
        System.out.println(netFilm.signSubscription(cl5));
        System.out.println(netFilm.signSubscription(cl6));
        System.out.println(netFilm.signSubscription(cl7));
        System.out.println(netFilm.signSubscription(cl8));
        System.out.println(netFilm.signSubscription(cl9));
        System.out.println(netFilm.signSubscription(cl10));
        System.out.println(netFilm.signSubscription(cl11));
        System.out.println(netFilm.signSubscription(cl12));

        mainMenu();
    }

    private static void showMenu()
    {
        System.out.print(
                "\nMENU\n" +
                "1. SHOW ALL CLIENTS\n" +
                "2. SIGN A NEW SUBSCRIPTION\n" +
                "3. END A SUBSCRIPTION\n" +
                "4. CHANGE SUBSCRIPTION OF A CLIENT\n" +
                "5. COUNT ACTIVE SUBSCRITIONS\n" +
                "6. DAYS OF SUBSCRIPTION\n" +
                "7. LIST ACTIVE SUBSCRIPTIORS\n" +
                "8. TOTAL VALUE\n" +
                "9. GET MONTHLY FEE OF A CLIENT\n" +
                "0. QUIT\n" +
                "CHOOSE MENU OPTION:"
        );
    }

    private static void mainMenu()
    {
        boolean isContinue = true;
        while (isContinue)
        {
            try
            {
                showMenu();
                isContinue = chooseOption();
            }
            catch (InputMismatchException e)
            {
                System.out.println("<!- ERROR: Invalid value option -!>");
            }
        }
    }

    private static boolean chooseOption() throws InputMismatchException
    {
        int option = SC.nextInt();

        switch (option)
        {
            case 1: // SHOW ALL CLIENTS
                showAllClients();
                break;
            case 2: // SIGN A NEW SUBSCRIPTION
                signNewSubscriptionClient();
                break;
            case 3: // END A SUBSCRIPTION
                endSubscriptionClient();
                break;
            case 4: // CHANGE SUBSCRIPTION OF A CLIENT
                changeSubscriptionClient();
                break;
            case 5: // COUNT ACTIVE SUBSCRITIONS
                countActiveSubscriptions();
                break;
            case 6: // DAYS OF SUBSCRIPTION
                daysSubsctiptions();
                break;
            case 7: // LIST ACTIVE SUBSCRIPTIORS
                listActiveSubscriptors();
                break;
            case 8: // TOTAL VALUE
                totalValue();
                break;
            case 9: // GET MONTHLY FEE OF A CLIENT
                getMonthlyFeeClient();
                break;
            case 0: // QUIT
                System.out.println("BYE!");
                return false;
            default:
                System.out.println("<- NON-EXISTENT OPTION ->");
                break;
        }

        return true;
    }

    private static void showAllClients()
    {
        System.out.println(netFilm);
    }

    private static void signNewSubscriptionClient()
    {
        SC.nextLine();
        System.out.print("\nENTER NAME CLIENT: ");
        String name = SC.nextLine();
        System.out.print("\nENTER DNI CLIENT: ");
        String dni = SC.nextLine();
        Subscription subscription = getNewSub();
        System.out.print("\nENTER INITIAL DATE: ");
        String initialDate = SC.nextLine();
        System.out.print("\nENTER END DATE: ");
        String endDate = SC.nextLine();
        System.out.print("\nENTER IBAN: ");
        String iban = SC.nextLine();
        Bank bank;
        while (true)
        {
            System.out.print("\nSELECT BANK: 1.FREEBANK, 2.COOLBANK: ");
            try
            {
                int numBank = SC.nextInt();
                SC.nextLine();
                if (numBank < 1 || numBank > 2)
                    throw new IllegalArgumentException("<!- NON-EXISTENT BANK NUMBER: " + numBank);
                else if (numBank == 1)
                    bank = banks[0];
                else
                    bank = banks[1];
                break;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
            catch (InputMismatchException e)
            {
                System.out.println("<!- ERROR: INVALID OPTION VALUE -!>");
            }
        }

        Client client;
        if (!initialDate.trim().isEmpty() && !endDate.trim().isEmpty())
            client = new Client(name, dni, subscription, initialDate, endDate, iban, bank);
        else if (!initialDate.trim().isEmpty())
            client = new Client(name, dni, subscription, initialDate, iban, bank);
        else
            client = new Client(name, dni, subscription, iban, bank);

        if (netFilm.signSubscription(client))
        {
            showAllClients();
        }
        else
        {
            System.out.println("<!- ERROR HAS OCURRED, THE CLIENT CANNOT SIGN UP FOR A SUBSCRIPTION -!>");
        }
    }

    private static void endSubscriptionClient()
    {
        SC.nextLine();
        System.out.print("\nENTER CODE CLIENT: ");
        String code = SC.nextLine();
        System.out.print("\nENTER END DATE: ");
        String date = SC.nextLine();

        if (netFilm.endSubscription(code, date))
        {
            System.out.println("END SUBS.: true");
            System.out.println(netFilm.searchClient(code));
        }
        else
        {
            System.out.println("END SUBS.: false");
        }
    }

    private static void changeSubscriptionClient()
    {
        SC.nextLine();
        System.out.print("\nENTER CODE CLIENT: ");
        String code = SC.nextLine();
        System.out.print("\nENTER DATE: ");
        String date = SC.nextLine();
        Subscription subscription = getNewSub();

        if (netFilm.changeSubscription(code, date, subscription))
        {
            System.out.println("CHANGE SUBS.: true");
            System.out.println(netFilm.searchClient(code));
        }
        else
        {
            System.out.println("CHANGE SUBS.: false");
        }
    }

    private static void countActiveSubscriptions()
    {
        SC.nextLine();
        System.out.print("\nENTER DATE: ");
        String date = SC.nextLine();
        System.out.println("NUM: " + netFilm.countSubscriptionsDate(date));
    }

    private static void daysSubsctiptions()
    {
        SC.nextLine();
        System.out.print("\nENTER CODE CLIENT: ");
        String code = SC.nextLine();
        System.out.println("NUM DAYS: " + netFilm.duration(code));
    }

    private static void listActiveSubscriptors()
    {
        SC.nextLine();
        System.out.print("\nENTER DATE: ");
        String date = SC.nextLine();
        netFilm.listActiveSubscriptions(date).forEach(System.out::println);
    }

    private static void totalValue()
    {
        SC.nextLine();
        System.out.print("\nENTER DATE: ");
        String date = SC.nextLine();
        System.out.println("TOTAL VALUE: " + netFilm.totalValue(date));
    }

    private static void getMonthlyFeeClient()
    {
        SC.nextLine();
        System.out.print("\nENTER CODE CLIENT: ");
        String code = SC.nextLine();
        System.out.println("FEE: " + netFilm.getMonthlyFee(code));
    }

    private static Subscription getNewSub()
    {
        Subscription subscription;
        while (true)
        {
            System.out.print("\nSELECT SUBSCRIPTION: 1.BASIC_ADVERT, 2.BASIC, 3.STANDARD, 4.PREMIUM: ");
            try
            {
                int numSub = SC.nextInt();
                SC.nextLine();
                subscription = Subscription.fromId(numSub);
                break;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
            catch (InputMismatchException e)
            {
                System.out.println("<!- ERROR: INVALID OPTION VALUE -!>");
            }
        }

        return subscription;
    }
}