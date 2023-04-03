using System.Collections.Generic;
using System.Windows;

namespace Databinding
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private IList<string> _list;
        //private ObservableCollection<string> list;

        public MainWindow()
        {
            InitializeComponent();

            _list = new List<string>() { "bread", "milk", "coffee" };
            //_list = new ObservableCollection<string>() { "bread", "milk", "coffee" };
        }

        private void bindButton_Click(object sender, RoutedEventArgs e)
        {
            shoppingListBox.ItemsSource = _list;
        }

        private void addButton_Click(object sender, RoutedEventArgs e)
        {
            //KH: bij List<string> --> geen automatische update naar ListBox
            //KH: bij ObservableCollection<string> --> wel automatische update
            _list.Add("tea");
        }
    }
}
