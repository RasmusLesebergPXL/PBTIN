using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace _17._7_Bankaccount
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private BankAccount _account = new BankAccount("BE1212343434", "RL", 2500);

        public MainWindow()
        {
            InitializeComponent();
            outputLabel.Content = Convert.ToString(_account.Saldo);
        }

        private void stortButton_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                int bedrag = Convert.ToInt32(bedragTextBox.Text);
                _account.Storten(bedrag);
                outputLabel.Content = Convert.ToString(_account.Saldo);
            }
            catch (InvalidBedragException ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void opneemButton_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                int bedrag = Convert.ToInt32(bedragTextBox.Text);
                _account.Opnemen(bedrag);
                outputLabel.Content = Convert.ToString(_account.Saldo);
            }
            catch (InvalidBedragException ex)
            {
                MessageBox.Show(ex.Message);
            }
        }
    }
}
