using System;
using System.Diagnostics;
using System.Text;
using System.Windows;

namespace Zoek_en_Vervang
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private string _randomString = "ab aa aabb abc bbb cc ccc bba ca bc";
        private string _output = "";
        private Stopwatch _stopwatch = new Stopwatch();

        public MainWindow()
        {
            InitializeComponent();
        }

        private void ExecuteButton_Click(object sender, RoutedEventArgs e)
        {
            _stopwatch.Start();
            string search = inputTextBox.Text;
            string replaceWith = replaceTextBox.Text;
            int methode = algoritmeComboBox.SelectedIndex;

            if (methode == 0)
            {
                outputTextBox.Text = Frasier(_output, search, replaceWith);
                
            } else if (methode == 1)
            {
                outputTextBox.Text = StringBuilderMethod(_output, search, replaceWith);
            }
            else if (methode == 2)
            {
                outputTextBox.Text = BibliotheekMethode(_output, search, replaceWith);
            }
            _stopwatch.Stop();
            uitvoeringsTijdLabel.Content = "Uitvoeringstijd is " + Convert.ToString(Math.Round(_stopwatch.Elapsed.TotalMilliseconds)) + " msec";
            _stopwatch.Reset();
        }

        private void ClearButton_Click(object sender, RoutedEventArgs e)
        {
            outputTextBox.Clear();
            uitvoeringsTijdLabel.Content = "";
            inputTextBox.Text = "";
            replaceTextBox.Text = "";
        }

        private void LoadButton_Click(object sender, RoutedEventArgs e)
        {   
            for (int i = 0; i < 10000; i++)
            {
                _output += _randomString;
            }
            outputTextBox.Text = _output;
        }

        private string Frasier(string original, string fromText, string toText)
        {
            string leftBit, rightBit;
            int startSearch = 0;
            int place = original.IndexOf(fromText);

            if (fromText.Length != 0)
            {
                while (place >= startSearch)
                {
                    leftBit = original.Substring(0, place);
                    rightBit = original.Substring(place + fromText.Length,
                                            original.Length - place - fromText.Length);
                    original = leftBit + toText + rightBit;
                    startSearch = leftBit.Length + toText.Length;
                    place = original.IndexOf(fromText);
                }
            }
            return original;
        }

        public string StringBuilderMethod(string original, string fromText, string toText)
        {
            StringBuilder builder = new();

            builder.Append(original.Replace(fromText, toText));
            return builder.ToString();
        }
        
        public string BibliotheekMethode(string original, string fromText, string toText)
        {
            return original.Replace(fromText, toText);
        }
    }
}
