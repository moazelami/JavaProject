import javax.swing.*;
import java.awt.*;


public class RectangleCalculator extends JFrame 
{
    private JTextField txtLength, txtWidth;
    private JLabel lablArea, lablPerimeter;
    private JButton butCalculate, butClear;
    
    public RectangleCalculator ()
    {
        setTitle("Rectangle Calculator");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));
        
        txtLength = new JTextField();
        txtWidth = new JTextField();

        lablArea = new JLabel("Area: ");
        lablPerimeter = new JLabel("Perimeter: ");

        butCalculate = new JButton("Calculate");
        butClear = new JButton("Clear");

        add(new JLabel("Length:"));
        add(txtLength);

        add(new JLabel("Width"));
        add(txtWidth);

        add(butCalculate);
        add(butClear);

        add(lablArea);
        add(lablPerimeter);

        butCalculate.addActionListener(ActionEvent -> calculate());
        butClear.addActionListener(ActionEvent  -> clear());
        txtLength.addActionListener(ActionEvent -> calculate());
        txtWidth.addActionListener(ActionEvent -> calculate());
        setVisible(true);
    }

    private void calculate()
    {
        try
        {
            double length = Double.parseDouble(txtLength.getText());
            double width = Double.parseDouble(txtWidth.getText());
            
            if(length <= 0 || width <= 0)
            {
                JOptionPane.showMessageDialog(this,"Please enter values greater than 0");
                return;
            }
            double area = length * width;
            double perimeter = 2 * (length + width);
            lablArea.setText("Area: " + area);
            lablPerimeter.setText("Perimeter: " + perimeter);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please enter valid numbers");
        }
    }

    private void clear()
    {
        txtLength.setText("");
        txtWidth.setText("");
        lablArea.setText("Area: ");
        lablPerimeter.setText("Perimeter: ");
    }
}
