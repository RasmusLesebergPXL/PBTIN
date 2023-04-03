using System;
using System.Collections.Generic;
using System.Windows;

namespace Festival
{
    /// <summary>
    /// Interaction logic for NewActWindow.xaml
    /// </summary>
    public partial class NewActWindow : Window
    {
        public List<Performer> _performers;

        public NewActWindow(List<Performer> performers)
        {
            InitializeComponent();
            _performers = performers;
        }


        private void BandRadioButton_Checked(object sender, RoutedEventArgs e)
        {
            if (typeCountLabel != null)
            {
                typeCountLabel.Content = "Members";
            }
        }

        private void SoloRadioButton_Checked(object sender, RoutedEventArgs e)
        {
            if (typeCountLabel != null)
            {
                typeCountLabel.Content = "Type of artist";
            }             
        }

        private void AddActButton_Click(object sender, RoutedEventArgs e)
        {
            //Ik wou alle velden op een handig manier checken voor "", maar was vergeten hoe, dus: 
            if (nameTextBox.Text == "" || typeCountTextBox.Text == "" || numberTextBox.Text == "" || 
                startHourTextBox.Text == "" || endHourTextBox.Text == "" || riderTextBox.Text == "" ||
                technicalTextBox.Text == "")
            {
                throw new FestivalException("Gelieve alle velden in te vullen");
            }

            List<string> riderItems = new List<string>();
            string[] techStuff = technicalTextBox.Text.Trim().Split(',');
            int[] techItems = { Convert.ToInt32(techStuff[0]), Convert.ToInt32(techStuff[1]) };
            string[] list = riderTextBox.Text.Trim().Split(',');

            for (int i = 6; i < list.Length; i++)
            {
                riderItems.Add(list[i]);
            }

            string members = typeCountTextBox.Text;
            string name = nameTextBox.Text;
            string reservation = numberTextBox.Text;
            string start = startHourTextBox.Text;
            string end = endHourTextBox.Text;

            if (bandRadioButton.IsChecked == true)
            {
                Band newBand = new Band(name, Convert.ToInt32(reservation), start, end, techItems,
                                    riderItems, Convert.ToInt32(members));

                try
                {
                    for (int i = 0; i < _performers.Count; i++)
                    {
                        if (_performers[i].StartTime < newBand.StartTime && _performers[i].EndTime > newBand.StartTime)
                        {
                            throw new FestivalException("Vorig optreden is nog niet beeindigd");
                        }
                        else if (_performers[i].EndTime < newBand.StartTime && newBand.EndTime > _performers[i + 1].StartTime)
                        {
                            throw new FestivalException("Optreden duurt te lang, het volgende optreden start " +
                                                        "voor het einde van dit optreden");
                        }
                    }
                    _performers.Add(newBand);
                }
                catch (FestivalException error)
                {
                    MessageBox.Show(error.Message, "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                }

            }
            else
            {
                Solo performer = new Solo(name, Convert.ToInt32(reservation), start, end, techItems,
                                    riderItems, members);

                try
                {
                    for (int i = 0; i < _performers.Count; i++)
                    {
                        if (_performers[i].StartTime < performer.StartTime && _performers[i].EndTime > performer.StartTime)
                        {
                            throw new FestivalException("Vorig optreden is nog niet beeindigd");
                        }
                        else if (_performers[i].EndTime < performer.StartTime && performer.EndTime > _performers[i + 1].StartTime)
                        {
                            throw new FestivalException("Optreden duurt te lang, het volgende optreden start " +
                                                        "voor het einde van dit optreden");
                        }
                    }
                    _performers.Add(performer);
                }
                catch (FestivalException error)
                {
                    MessageBox.Show(error.Message, "Error", MessageBoxButton.OK, MessageBoxImage.Error);
                }
            }
            this.Close();
        }
    }
}
