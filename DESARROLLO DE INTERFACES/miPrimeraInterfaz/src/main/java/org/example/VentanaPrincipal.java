package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        initComponents();
    }

    public void initComponents() {
        setTitle("Mi aplicación con GUI");
        setSize(420, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Números
        JButton botonNum1 = new JButton("1");
        JButton botonNum2 = new JButton("2");
        JButton botonNum3 = new JButton("3");
        JButton botonNum4 = new JButton("4");
        JButton botonNum5 = new JButton("5");
        JButton botonNum6 = new JButton("6");
        JButton botonNum7 = new JButton("7");
        JButton botonNum8 = new JButton("8");
        JButton botonNum9 = new JButton("9");
        JButton botonNum0 = new JButton("0");

        // Signos
        JButton botonClear = new JButton("C");
        JButton botonAdd = new JButton("+");
        JButton botonSub = new JButton("-");
        JButton botonMul = new JButton("x");
        JButton botonDiv = new JButton("/");
        JButton botonMod = new JButton("%");
        JButton botonSqr = new JButton("sqrt");
        JButton botonComa = new JButton(",");
        JButton botonSign = new JButton("+/-");
        JButton botonEqual = new JButton("=");

        JTextField resultField = new JTextField();

        resultField.setBounds(10, 10, 380, 30);
        resultField.setEditable(false);
        resultField.setHorizontalAlignment(SwingConstants.RIGHT);

        setLayout(null);

        botonNum1.setBounds(10, 170, 80, 30);
        botonNum2.setBounds(110, 170, 80, 30);
        botonNum3.setBounds(210, 170, 80, 30);
        botonNum4.setBounds(10, 130, 80, 30);
        botonNum5.setBounds(110, 130, 80, 30);
        botonNum6.setBounds(210, 130, 80, 30);
        botonNum7.setBounds(10, 90, 80, 30);
        botonNum8.setBounds(110, 90, 80, 30);
        botonNum9.setBounds(210, 90, 80, 30);
        botonNum0.setBounds(110, 210, 80, 30);
        botonClear.setBounds(210, 50, 80, 30);
        botonAdd.setBounds(310, 170, 80, 30);
        botonSqr.setBounds(110, 50, 80, 30);
        botonSub.setBounds(310, 130, 80, 30);
        botonMul.setBounds(310, 90, 80, 30);
        botonDiv.setBounds(310, 50, 80, 30);
        botonEqual.setBounds(310, 210, 80, 30);
        botonSign.setBounds(10, 210, 80, 30);
        botonComa.setBounds(210, 210, 80, 30);
        botonMod.setBounds(10, 50, 80, 30);

        add(botonNum1);
        botonNum1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "1");
            }
        });
        add(botonNum2);
        botonNum2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "2");
            }
        });
        add(botonNum3);
        botonNum3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "3");
            }
        });
        add(botonNum4);
        botonNum4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "4");
            }
        });
        add(botonNum5);
        botonNum5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "5");
            }
        });
        add(botonNum6);
        botonNum6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "6");
            }
        });
        add(botonNum7);
        botonNum7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "7");
            }
        });
        add(botonNum8);
        botonNum8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "8");
            }
        });
        add(botonNum9);
        botonNum9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "9");
            }
        });
        add(botonNum0);
        botonNum0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + "0");
            }
        });
        add(botonClear);
        botonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText("");
            }
        });
        add(botonAdd);
        botonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + " + ");
            }
        });
        add(botonSqr);
        add(botonSub);
        botonSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + " - ");
            }
        });
        add(botonMul);
        botonMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + " x ");
            }
        });
        add(botonDiv);
        botonDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(resultField.getText() + " / ");
            }
        });
        add(botonEqual);
        botonEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateDisplayField(resultField);
            }
        });
        add(botonSign);
        add(botonComa);
        add(botonMod);
        add(resultField);
    }

    private void calculateDisplayField(JTextField displayField)
    {
        /*String[] numbersAndSigns = displayField.getText().split(" ");
        double result = 0;
        Double firstNumber = null;
        Double secondNumber = null;
        char sign = '0';
        boolean isSigned = false;

        // Comprobacion Multiplicacion y Division
        for (int i = 0; i < numbersAndSigns.length; i++)
        {
            if (!numbersAndSigns[i].equalsIgnoreCase("x") && !numbersAndSigns[i].equalsIgnoreCase("/")
                    && !numbersAndSigns[i].equalsIgnoreCase("-")
                    && !numbersAndSigns[i].equalsIgnoreCase("+"))
            {
                if (!isSigned)
                    firstNumber = Double.parseDouble(numbersAndSigns[i]);
                else
                    secondNumber = Double.parseDouble(numbersAndSigns[i]);
            }
            else
            {
                sign = numbersAndSigns[i].charAt(0);
                isSigned = true;
            }

            if (firstNumber != null && secondNumber != null && (sign == 'x' || sign == '/'))
            {
                switch (sign)
                {
                    case 'x':
                        result = firstNumber * secondNumber;
                        break;
                    case '/':
                        result = firstNumber / secondNumber;
                        break;
                }
                numbersAndSigns[i-2] = " ";
                numbersAndSigns[i-1] = " ";
                numbersAndSigns[i] = String.format("%f", result);
                isSigned = false;
                firstNumber = null;
                secondNumber = null;
            }
        }

        isSigned = false;
        firstNumber = null;
        secondNumber = null;

        // Comprobacion Suma y Resta
        numbersAndSigns = displayField.getText().split(" ");

        for (int i = 0; i < numbersAndSigns.length; i++)
        {
            if (!numbersAndSigns[i].equalsIgnoreCase("-") && !numbersAndSigns[i].equalsIgnoreCase("+") &&
                    !numbersAndSigns[i].equalsIgnoreCase("x") && !numbersAndSigns[i].equalsIgnoreCase("/"))
            {
                if (!isSigned)
                    firstNumber = Double.parseDouble(numbersAndSigns[i]);
                else
                    secondNumber = Double.parseDouble(numbersAndSigns[i]);
            }
            else
            {
                sign = numbersAndSigns[i].charAt(0);
                isSigned = true;
            }

            if (firstNumber != null && secondNumber != null)
            {
                switch (sign)
                {
                    case '+':
                        result = firstNumber + secondNumber;
                        break;
                    case '-':
                        result = firstNumber - secondNumber;
                        break;
                }
                numbersAndSigns[i-2] = " ";
                numbersAndSigns[i-1] = " ";
                numbersAndSigns[i] = String.format("%f", result);
                firstNumber = null;
                secondNumber = null;
                isSigned = false;
            }
        }

        String temporalNumbers = "";
        for (String s : numbersAndSigns)
        {
            temporalNumbers += s;
        }

        displayField.setText(temporalNumbers.trim());*/

        String expresion = displayField.getText().replace("x", "*");

        List<String> tokens = new ArrayList<>();
        StringBuilder numero = new StringBuilder();
        for (char c : expresion.toCharArray())
        {
            if (Character.isDigit(c) || c == '.')
            {
                numero.append(c);
            }
            else if ("+-*/".indexOf(c) >= 0)
            {
                if (!numero.isEmpty())
                {
                    tokens.add(numero.toString());
                    numero.setLength(0);
                }
                tokens.add(String.valueOf(c));
            }
        }
        if (!numero.isEmpty())
            tokens.add(numero.toString());

        // Resolver * y /
        for (int i = 0; i < tokens.size(); i++)
        {
            String token = tokens.get(i);
            if (token.equals("*") || token.equals("/"))
            {
                double izq = Double.parseDouble(tokens.get(i - 1));
                double der = Double.parseDouble(tokens.get(i + 1));
                double res = token.equals("*") ? izq * der : izq / der;

                tokens.set(i - 1, String.valueOf(res));
                tokens.remove(i);
                tokens.remove(i);
                i--;
            }
        }

        // Resolver + y -
        double resultado = Double.parseDouble(tokens.getFirst());
        for (int i = 1; i < tokens.size(); i += 2)
        {
            String op = tokens.get(i);
            double num = Double.parseDouble(tokens.get(i + 1));
            if (op.equals("+")) resultado += num;
            else resultado -= num;
        }
        
        displayField.setText(String.valueOf(resultado));
    }

    public static void main(String[] args)
    {
        new VentanaPrincipal().setVisible(true);
    }
}
