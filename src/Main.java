import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame
        extends JFrame
        implements ActionListener {

    /* Form Components */
    private Container c;
    private JLabel title;

    private JLabel labelRadius;
    private JTextField radius;

    private JLabel labelTinggi;
    private JTextField tinggi;

    private JButton submitButton;
    private JButton resetButton;

    private JTextArea output;

    private JLabel response;
    private JTextArea responseArea;

    /* constructor, to initialize components */
    public MyFrame()
    {
        String heading = "Hitung Volume Tabung";

        setTitle(heading);
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel(heading);
        title.setFont(new Font("Arial", Font.PLAIN, 24));
        title.setSize(400, 30);
        title.setLocation(300, 30);
        c.add(title);

        labelRadius = new JLabel("Jari-jari Lingkaran");
        labelRadius.setFont(new Font("Arial", Font.PLAIN, 14));
        labelRadius.setSize(200, 20);
        labelRadius.setLocation(100, 100);
        c.add(labelRadius);

        radius = new JTextField();
        radius.setFont(new Font("Arial", Font.PLAIN, 15));
        radius.setSize(190, 20);
        radius.setLocation(250, 100);
        c.add(radius);

        labelTinggi = new JLabel("Tinggi Tabung");
        labelTinggi.setFont(new Font("Arial", Font.PLAIN, 14));
        labelTinggi.setSize(200, 20);
        labelTinggi.setLocation(100, 150);
        c.add(labelTinggi);

        tinggi = new JTextField();
        tinggi.setFont(new Font("Arial", Font.PLAIN, 15));
        tinggi.setSize(190, 20);
        tinggi.setLocation(250, 150);
        c.add(tinggi);


        submitButton = new JButton("Hitung");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 15));
        submitButton.setSize(100, 20);
        submitButton.setLocation(100, 200);
        submitButton.addActionListener(this);
        c.add(submitButton);

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 15));
        resetButton.setSize(100, 20);
        resetButton.setLocation(250, 200);
        resetButton.addActionListener(this);
        c.add(resetButton);

        output = new JTextArea();
        output.setFont(new Font("Arial", Font.PLAIN, 15));
        output.setSize(300, 300);
        output.setLocation(500, 100);
        output.setLineWrap(true);
        output.setEditable(false);
        c.add(output);

        response = new JLabel("");
        response.setFont(new Font("Arial", Font.PLAIN, 14));
        response.setSize(500, 25);
        response.setLocation(100, 300);
        c.add(response);

        responseArea = new JTextArea();
        responseArea.setFont(new Font("Arial", Font.PLAIN, 15));
        responseArea.setSize(200, 75);
        responseArea.setLocation(580, 175);
        responseArea.setLineWrap(true);
        c.add(responseArea);

        setVisible(true);
    }

    /* method to get the action performed by the user and act accordingly */
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == resetButton) {
            String defaultValue = "";
            radius.setText(defaultValue);
            tinggi.setText(defaultValue);
            response.setText(defaultValue);
            output.setText(defaultValue);
            responseArea.setText(defaultValue);
            return;
        }
        if(radius.getText().equals("") || tinggi.getText().equals("")) {
            output.setText("");
            responseArea.setText("");
            response.setText("Jari-jari lingkaran dan tinggi tabung harus di isi !");
            response.setForeground(Color.RED);
            return;
        }

        double r, t, volume;
        final double phi = Math.PI;
        try {
            r = Double.parseDouble(radius.getText());
            t = Double.parseDouble(tinggi.getText());
            if( r < 1 || t < 1 ) {
                throw new Exception("Jari-jari lingkaran dan tinggi tabung harus lebih dari 0!");
            }
            volume = Math.round(phi * (r * r * t));
            System.out.println("R " + r + "T " + t + "V" + volume + "phi" + phi);
        } catch (NumberFormatException err) {
            response.setText("Jari-jari lingkaran dan tinggi tabung harus di isi dengan angka!");
            response.setForeground(Color.RED);
            return;
        } catch (Exception err) {
            response.setText(err.getMessage());
            return;
        }

        String data = "radius = "
                + radius.getText() + "\n"
                + "tinggi = "
                + tinggi.getText() + "\n\n"
                + "Volume Tabung = "
                + volume + "\n";

        output.setText(data);
        output.setEditable(false);
        response.setText("Berhasil menghitung volume tabung");
        response.setForeground(Color.green);
    }
}

class Main {

    public static void main(String[] args) throws Exception
    {
        MyFrame f = new MyFrame();
    }
}
