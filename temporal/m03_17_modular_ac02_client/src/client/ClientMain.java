package client;

public class ClientMain {
    public static void main(String[] args)
    {
        // Use Constructor 1
        Client client1 = new Client("C-001", "Juan Francisco", "Sanchez","ES" ,"+34 556698741","55566621Q", (byte)28);

        // Check attributes debt and active are initialize
        System.out.println("Deudas c1: " + client1.getDebts() + " | Actividad: " + client1.isActive());

        // Use Constructor 2
        Client client2 = new Client("C-002", "Daniel", "Fernandez Pinto", "33215478R");

        // Check all other attributes that are not in the constructor are initialize
        System.out.println("Deudas c1: " + client2.getDebts() + " | Actividad: " + client2.isActive());

        // Test getters and setter setAccount & getAccount
        System.out.println("Cuenta c2: " + client2.getAccount());
        client2.setAccount("C-995");
        System.out.println("Cuenta c2: " + client2.getAccount());

        // Test getters and setter setName & getName
        System.out.println("Name c2: " + client2.getName());
        client2.setName("Hassan");
        System.out.println("Name c2: " + client2.getName());

        // Test getters and setter setSurname & getSurname
        System.out.println("Surname c2: " + client2.getSurname());
        client2.setSurname("Makuhita");
        System.out.println("Surname c2: " + client2.getSurname());

        // Test getters and setter setNationality & getNationality
        System.out.println("Nationality c2: " + client2.getNationality());
        client2.setNationality("PK");
        System.out.println("Nationality c2: " + client2.getNationality());

        // Test getters and setter setPhone & getPhone
        System.out.println("Phone c2: " + client2.getPhone());
        client2.setPhone("+81 445 8547 63");
        System.out.println("Phone c2: " + client2.getPhone());

        // Test getters and setter setDni & getDni
        System.out.println("DNI c2: " + client2.getDni());
        client2.setDni("Miss documents");
        System.out.println("DNI c2: " + client2.getDni());

        // Test getters and setter setAge & getAge
        System.out.println("Age c1: " + client1.getAge());
        client1.setAge((byte) 30);
        System.out.println("Age c1: " + client1.getAge());

        // Test getters and setter setDebt & getDebt
        System.out.println("Debts c1: " + client1.getDebts());
        client1.setDebts(120.25f);
        System.out.println("Debts c1: " + client1.getDebts());

        // Test isActive and setActive
        System.out.println("Active c2: " + client2.isActive());
        client2.setActive(false);
        System.out.println("Active c2: " + client2.isActive());

        // Test toString
        System.out.println(client1.toString());
        System.out.println(client2.toString());

        // Test cancelDebts
        client2.setActive(true);
        System.out.println("Deudas canceladas cliente 2: " + client2.cancelDebts());

        // Test reduceDebt with amount = 50 (set initial debt to 120.25), result = true, debt = 70.25
        client1.setDebts(120.25f);
        System.out.println("Reducir deudas cliente 1: " + client1.reduceDebts(50));
        System.out.println(client1.getDebts());

        // Test reduceDebt with amount = 150 (set initial debt to 120.25), result = true, debt = 0
        client1.setDebts(120.25f);
        System.out.println("Reducir deudas cliente 1: " + client1.reduceDebts(150));
        System.out.println(client1.getDebts());

        // Test reduceDebt with amount = -100 (set initial debt to 120.25), result = false, debt = 120.25
        client1.setDebts(120.25f);
        System.out.println("Reducir deudas cliente 1: " + client1.reduceDebts(-100));
        System.out.println(client1.getDebts());

        // Test increaseDebt with amount = 50 (set initial debt to 120.25), result = true, debt = 170.25
        client1.setDebts(120.25f);
        System.out.println("Incrementar deudas cliente 1: " + client1.increaseDebts(50));
        System.out.println(client1.getDebts());

        // Test increaseDebt with amount = -50 (set initial debt to 120.25), result = false, debt = 120.25
        client1.setDebts(120.25f);
        System.out.println("Incrementar deudas cliente 1: " + client1.increaseDebts(-50));
        System.out.println(client1.getDebts());

    }
}