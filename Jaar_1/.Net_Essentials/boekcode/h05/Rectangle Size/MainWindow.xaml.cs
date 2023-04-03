using System.Windows;

namespace Rectangle_Size
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, RoutedEventArgs e)
        {
            int rectangleWidth = 8, rectangleHeight = 6;
            IncreaseSize(ref rectangleWidth, ref rectangleHeight);
            IncreaseSize(ref rectangleWidth, ref rectangleHeight);
            IncreaseSize(ref rectangleWidth, ref rectangleHeight);
        }

        private void IncreaseSize(ref int width, ref int height)
        {
            int area;
            width = width + 2;
            height = height + 2;
            area = width * height;

            MessageBox.Show($"Rectangle size: {width} by {height}. Area is {area}");
        }
    }
}
