using System;
using System.Windows;
using System.Windows.Media.Imaging;

namespace BikeRent
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private BikeBase _bike;
        private Company _company;
        private BitmapImage _maleBikeImage;
        private BitmapImage _femaleBikeImage;
        private BitmapImage _electricalImage;
        
        public MainWindow()
        {
            InitializeComponent();

            _maleBikeImage = ImageUtils.CreateBitmapImage("Images/MaleBike.png");
            _femaleBikeImage = ImageUtils.CreateBitmapImage("Images/FemaleBike.png");
            _electricalImage = ImageUtils.CreateBitmapImage("Images/Electrical.png");

            _company = new Company();
            
            BindCurrentBike(_company.CurrentBike);
        }

        private void nextButton_Click(object sender, RoutedEventArgs e)
        {
            _company.Next();
            BindCurrentBike(_company.CurrentBike);
        }

        private void BindCurrentBike(BikeBase bike)
        {
            _bike = bike;

            idTextBlock.Text = Convert.ToString($"00{bike.Id}");
            brandTextBlock.Text = Convert.ToString(bike.Brand);
            typeTextBlock.Text = Convert.ToString(bike.Type);
            descriptionTextBlock.Text = Convert.ToString(bike.Description);

            maintenanceProgressBar.Value = bike.TotalDistance;
            maintenanceTextBlock.Text = Convert.ToString($"{bike.TotalDistance}/10000");
            rentStatusTextBlock.Text = $"Verhuurd aan";

            if (bike.Gender == Gender.Male)
            {
                genderImage = new System.Windows.Controls.Image
                {
                    Source = _maleBikeImage
                };
            } else
            {
                genderImage = new System.Windows.Controls.Image
                {
                    Source = _femaleBikeImage
                };
            }
       
            if (bike is EBike)
            {
                batteryTextBlock.Text = Convert.ToString(((EBike)bike).BatteryCapacity);
                electricalImage.Visibility = Visibility.Visible;
            }
           
            // ToDo:
            //  - Place info on the screen
            //  - look at the screenshots to know exactly what and when
        }

        private void rentOrReturnButton_Click(object sender, RoutedEventArgs e)
        {

            // ToDo: Show a new RentalWindow object as a modal dialog
            //       and pass along the information from the CurrentBike.
            //       After the RentalWindow is closed, update the information in
            //       this window.
        }

        private void exportItem_Click(object sender, RoutedEventArgs e)
        {
            // ToDo
            //  Create a report on the desktop of the current user
            //  report name: e.g. Bike_003.html (use Id property)
            //  Use CreateReport from ReportUtils   
        }

        private void exitItem_Click(object sender, RoutedEventArgs e)
        {
            Environment.Exit(0);
        }
    }
}
