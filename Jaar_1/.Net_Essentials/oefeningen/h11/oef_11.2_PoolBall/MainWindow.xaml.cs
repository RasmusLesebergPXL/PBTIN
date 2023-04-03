using System;
using System.Windows;

namespace oef_11._2_PoolBall
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private PoolBall _poolball;
        private int _amount;
        public MainWindow()
        {
            InitializeComponent();

            _poolball = new PoolBall();
            _poolball.CreateEllipse(paperCanvas);
        }

        private void leftButton_Click(object sender, RoutedEventArgs e)
        {
            _amount = Convert.ToInt32(amountTextBox.Text);
            _poolball.MoveLeft(_amount);
        }

        private void buttonUp_Click(object sender, RoutedEventArgs e)
        {
            _amount = Convert.ToInt32(amountTextBox.Text);
            _poolball.MoveUp(_amount);
        }

        private void rightButton_Click(object sender, RoutedEventArgs e)
        {
            _amount = Convert.ToInt32(amountTextBox.Text);
            _poolball.MoveRight(_amount);
        }

        private void downButton_Click(object sender, RoutedEventArgs e)
        {
            _amount = Convert.ToInt32(amountTextBox.Text);
            _poolball.MoveDown(_amount);
        }
    }
}
