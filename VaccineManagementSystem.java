import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

class Vaccine {
    private String name;
    private int quantity;

    public Vaccine(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class Appointment {
    private String name;
    private String date;

    public Appointment(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}

public class VaccineManagementSystem extends JFrame implements ActionListener {
    private List<Vaccine> vaccines = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    private JTextField vaccineNameField, vaccineQuantityField, appointmentNameField, appointmentDateField;
    private JTextArea vaccineInventoryArea, appointmentScheduleArea;

    public VaccineManagementSystem() {
        setTitle("Corona Vaccine Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(2, 2));

        JPanel vaccinePanel = new JPanel(new GridLayout(4, 1));
        vaccinePanel.setBorder(BorderFactory.createTitledBorder("Vaccine Inventory"));

        JLabel vaccineNameLabel = new JLabel("Vaccine Name:");
        vaccineNameField = new JTextField();
        JLabel vaccineQuantityLabel = new JLabel("Quantity:");
        vaccineQuantityField = new JTextField();
        JButton addVaccineButton = new JButton("Add Vaccine");
        addVaccineButton.addActionListener(this);

        vaccineInventoryArea = new JTextArea();
        JScrollPane vaccineScrollPane = new JScrollPane(vaccineInventoryArea);

        vaccinePanel.add(vaccineNameLabel);
        vaccinePanel.add(vaccineNameField);
        vaccinePanel.add(vaccineQuantityLabel);
        vaccinePanel.add(vaccineQuantityField);
        vaccinePanel.add(addVaccineButton);
        vaccinePanel.add(vaccineScrollPane);

        JPanel appointmentPanel = new JPanel(new GridLayout(4, 1));
        appointmentPanel.setBorder(BorderFactory.createTitledBorder("Appointment Schedule"));

        JLabel appointmentNameLabel = new JLabel("Name:");
        appointmentNameField = new JTextField();
        JLabel appointmentDateLabel = new JLabel("Date:");
        appointmentDateField = new JTextField();
        JButton scheduleAppointmentButton = new JButton("Schedule Appointment");
        scheduleAppointmentButton.addActionListener(this);

        appointmentScheduleArea = new JTextArea();
        JScrollPane appointmentScrollPane = new JScrollPane(appointmentScheduleArea);

        appointmentPanel.add(appointmentNameLabel);
        appointmentPanel.add(appointmentNameField);
        appointmentPanel.add(appointmentDateLabel);
        appointmentPanel.add(appointmentDateField);
        appointmentPanel.add(scheduleAppointmentButton);
        appointmentPanel.add(appointmentScrollPane);

        mainPanel.add(vaccinePanel);
        mainPanel.add(appointmentPanel);

        add(mainPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Vaccine")) {
            String name = vaccineNameField.getText();
            int quantity = Integer.parseInt(vaccineQuantityField.getText());
            Vaccine vaccine = new Vaccine(name, quantity);
            vaccines.add(vaccine);
            updateVaccineInventory();
        } else if (e.getActionCommand().equals("Schedule Appointment")) {
            String name = appointmentNameField.getText();
            String date = appointmentDateField.getText();
            Appointment appointment = new Appointment(name, date);
            appointments.add(appointment);
            updateAppointmentSchedule();
        }
    }

    private void updateVaccineInventory() {
        StringBuilder inventory = new StringBuilder();
        inventory.append("Vaccine Inventory:\n");
        for (Vaccine vaccine : vaccines) {
            inventory.append(vaccine.getName()).append(": ").append(vaccine.getQuantity()).append("\n");
        }
        vaccineInventoryArea.setText(inventory.toString());
    }

    private void updateAppointmentSchedule() {
        StringBuilder schedule = new StringBuilder();
        schedule.append("Appointment Schedule:\n");
        for (Appointment appointment : appointments) {
            schedule.append("Name: ").append(appointment.getName()).append(", Date: ").append(appointment.getDate()).append("\n");
        }
        appointmentScheduleArea.setText(schedule.toString());
    }

    public static void main(String[] args) {
        new VaccineManagementSystem();
    }
}
