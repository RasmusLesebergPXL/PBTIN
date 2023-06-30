using DartApp.AppLogic.Contracts;
using DartApp.Domain.Contracts;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Windows;
using System.Windows.Controls;

namespace DartApp.Presentation
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window, INotifyPropertyChanged
    {
        private IPlayerService _service;
        private IPlayer? _player;

        public MainWindow(IPlayerService playerService)
        {
            DataContext = this;
            InitializeComponent();
            _service = playerService;
            AllPlayers = new ObservableCollection<IPlayer>();

            IReadOnlyList<IPlayer> playerList = _service.GetAllPlayers();
            AllPlayers = new ObservableCollection<IPlayer>(playerList);

            PlayerComboBox.ItemsSource = AllPlayers;
        }
        public ObservableCollection<IPlayer> AllPlayers { get; set; }

        public Visibility ShowSelectedPlayer => SelectedPlayer == null ? Visibility.Hidden : Visibility.Visible;

        public IPlayer? SelectedPlayer
        {
            get => _player;
            set
            {
                if (value != null)
                {
                    _player = value;
                    OnPropertyChanged(nameof(SelectedPlayer));
                    OnPropertyChanged(nameof(ShowSelectedPlayer));
                }
            }
        }



        public IPlayerStats? PlayerStats { get; set; }

        private void OnPlayerSelectionChanged(object sender, SelectionChangedEventArgs e) { }

        private void OnAddPlayerClick(object sender, RoutedEventArgs e)
        {

            IPlayer player = _service.AddPlayer(SelectedPlayer?.Name);
            AllPlayers.Add(player);
            SelectedPlayer = player;
            PlayerNameTextBox.Text = "";

        }

        private void OnAddGameResultClick(object sender, RoutedEventArgs e)
        {
            int numberOf180s = Int32.Parse(GameResultNumberOf180TextBox.Text);
            int bestThrow = Int32.Parse(GameResultBestThrowTextBox.Text);
            double average = Double.Parse(GameResultAverageTextBox.Text);

            _service.AddGameResultForPlayer(SelectedPlayer!, numberOf180s, average, bestThrow);

            GameResultAverageTextBox.Text = "";
            GameResultBestThrowTextBox.Text = "";
            GameResultNumberOf180TextBox.Text = "";
        }

        private void OnCalculateStats(object sender, RoutedEventArgs e)
        {
            _service.GetStatsForPlayer(SelectedPlayer);
        }

        public event PropertyChangedEventHandler? PropertyChanged;

        protected virtual void OnPropertyChanged(string propertyName)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
