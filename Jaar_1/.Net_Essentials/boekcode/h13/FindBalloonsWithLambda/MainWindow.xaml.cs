using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Media;
using System.Windows.Shapes;

namespace FindBalloonsWithLambda
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private List<Balloon> _partyList = new List<Balloon>();
        private List<Ellipse> _ellipseList = new List<Ellipse>();

        public MainWindow()
        {
            InitializeComponent();

            _ellipseList.Add(CreateEllipse());
            _ellipseList.Add(CreateEllipse());
            _ellipseList.Add(CreateEllipse());

            _partyList.Add(CreateBalloon());
            _partyList.Add(CreateBalloon());
            _partyList.Add(CreateBalloon());
        }

        private Balloon CreateBalloon()
        {
            var balloon = new Balloon();
            balloon.BalloonChanged += UpdateEllipse;

            return balloon;
        }

        private Ellipse CreateEllipse()
        {
            var ellipse = new Ellipse()
            {
                Stroke = new SolidColorBrush(Colors.Blue),
                StrokeThickness = 2
            };

            balloonCanvas.Children.Add(ellipse);
            return ellipse;
        }

        private void UpdateEllipse(object sender, BalloonChangedEventArgs args)
        {
            int balloonIndex = _partyList.IndexOf((Balloon)sender);
            var ellipse = _ellipseList[balloonIndex];
            ellipse.Margin = new Thickness(args.X, args.Y, 0, 0);
            ellipse.Width = args.Diameter;
            ellipse.Height = args.Diameter;
        }

        private void drawButton_Click(object sender, RoutedEventArgs e)
        {
            _partyList[0].Initialize(10, 10, 50);
            _partyList[1].Initialize(50, 50, 100);
            _partyList[2].Initialize(100, 100, 200);
        }

        private void findButton_Click(object sender, RoutedEventArgs e)
        {
            //List<Balloon> foundBalloons = partyList.FindAll(b => {
            //    return b.Diameter < 150;
            //});

            List<Balloon> foundBalloons = _partyList.FindAll(b => b.Diameter < 150);

            foreach (var balloon in foundBalloons)
            {
                MarkEllipse(balloon);
            }
        }

        private void MarkEllipse(Balloon balloon)
        {
            int balloonIndex = _partyList.IndexOf(balloon);
            Ellipse ellipse = _ellipseList[balloonIndex];
            ellipse.Fill = new SolidColorBrush(Colors.Red);
        }
    }
}
