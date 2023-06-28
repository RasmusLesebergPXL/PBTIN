using System.Windows;

namespace Exercise14
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void berekenButton_Click(object sender, RoutedEventArgs e)
        {
            string message = string.Empty;
            if ((bool)manButton.IsChecked )
            {
                message += manButton.Content + "\n";
            }
            if ((bool)vrouwButton.IsChecked)
            {
                message += vrouwButton.Content + "\n";
            }
            if ((bool)tussen18En30.IsChecked)
            {
                message += tussen18En30.Content + "\n";
            }
            if ((bool)tussen30En45.IsChecked)
            {
                message += tussen30En45.Content + "\n";
            }
            if ((bool)tussen45En60.IsChecked)
            {
                message += tussen45En60.Content + "\n";
            }
            if ((bool)ouderDan60.IsChecked)
            {
                message += ouderDan60.Content + "\n";
            }
           
            MessageBox.Show($"{message}");
        }

        //To try to not repeat code
        //
        //public YourForm()
        //{
        //    radioButton1.Tag = groupBox1;
        //    radioButton2.Tag = groupBox2;
        //    radioButton3.Tag = groupBox3;

        //    radioButton1.CheckedChanged += radioButtons_CheckedChanged;
        //    radioButton2.CheckedChanged += radioButtons_CheckedChanged;
        //    radioButton3.CheckedChanged += radioButtons_CheckedChanged;
        //}

        //void radioButtons_CheckedChanged(object sender, EventArgs e)
        //{
        //    RadioButton button = sender as RadioButton;
        //    if (button == null) return;

        //    GroupBox box = button.Tag as GroupBox
        //    if (box == null) return;

        //    box.Enabled = button.Checked;
        
    }
}
