using System;
using System.Windows;

namespace TestVraag7_5
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private int _salary = 0;
        private double _tax = 0;
        
        public MainWindow()
        {
            InitializeComponent();
            showSalary();
            showTax();
            salarySlider.ValueChanged += salarySlider_ValueChanged;
        }

        private void salarySlider_ValueChanged(object sender,
                                 RoutedPropertyChangedEventArgs<double> e)
        {
            showSalary();
            showTax();
        }

        private void showSalary()
        {
            _salary = Convert.ToInt32(salarySlider.Value);
            salaryLabel.Content = $"{0:salary}";
        }

        private void showTax()
        {
            if (_salary <= 10000)
            {
                _tax = 0;
            }
            if ((_salary > 10000) && (_salary <= 50000))
            {
                _tax = (_salary - 10000) * 0.2;
            }
            if (_salary > 50000)
            {
                _tax = 8000 + ((_salary - 50000) * 0.9);
            }

            belastingLabel.Content = $"{0:tax}";
        }
    }
}
