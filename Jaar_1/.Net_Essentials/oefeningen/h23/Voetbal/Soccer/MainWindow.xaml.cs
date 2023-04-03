using System;
using System.Collections.Generic;
using System.IO;
using System.Windows;

namespace Soccer
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private const int MaximumNumberOfPlayers = 11;
        private List<Player> _list;
        private List<Team> _teamsOne;
        private List<Team> _teamsTwo;
        public MainWindow()
        {
            InitializeComponent();

            _list = new List<Player>();
            _teamsOne = new List<Team>();
            _teamsTwo = new List<Team>();
        }

        private void SwitchTeams()
        {
            _teamsTwo.Insert(0, _teamsOne[1]);
            //_teamsOne.Remove(_teamsOne[1]);
            _teamsOne.Insert(_teamsOne.Count - 1, _teamsTwo[_teamsTwo.Count - 1]);
            //_teamsTwo.Remove(_teamsTwo[_teamsTwo.Count - 1]);
        }

        private void ReadTeamsOption_Click(object sender, RoutedEventArgs e)
        {
            int playerCount = 0;
            int teamCount = 0;
            StreamReader teamsReader = null;
            try
            {
                teamsReader = File.OpenText(@"..\..\..\Teams.txt");
                string line = teamsReader.ReadLine();

                while (line != null)
                {
                    StreamReader playerReader = null;
                    string[] teamInfo = line.Trim().Split(',');

                    try
                    {
                        _list = new List<Player>();
                        playerReader = File.OpenText(@"..\..\..\Players.txt");
                        
                        string playerLine = playerReader.ReadLine();
                        for (int i = playerCount; i < playerCount + MaximumNumberOfPlayers; i++)
                        {
                            string[] playerInfo = playerLine.Trim().Split(',');
                            PlayerFunction function;

                            if (playerInfo[4].Equals('G'))
                            {
                                function = PlayerFunction.Goalkeeper;
                            }
                            else if (playerInfo[4].Equals('M'))
                            {
                                function = PlayerFunction.Midfielder;
                            }
                            else if (playerInfo[4].Equals('F'))
                            {
                                function = PlayerFunction.Forward;
                            }
                            else
                            {
                                function = PlayerFunction.Defender;
                            }
                            Player player = new Player(playerInfo[3], playerInfo[2], playerInfo[1], function);
                            _list.Add(player);
                            playerLine = playerReader.ReadLine();
                        }
                    }      
                    finally
                    {
                        playerReader?.Close();
                        playerCount += 11;
                    }

                    Team team = new Team(teamInfo[0], teamInfo[1], _list);
                    teamCount++;
    
                    if (teamCount <=7)
                    {
                        _teamsOne.Add(team);
                    } else
                    {
                        _teamsTwo.Add(team);
                    }
                    line = teamsReader.ReadLine();
                }
            }
            finally
            {
                teamsReader?.Close();
            }
            competitionMenuItem.IsEnabled = true;
        }

        private void ComposeGamesOption_Click(object sender, RoutedEventArgs e)
        {
            int matchDay = 1;
            DateTime date = new DateTime(DateTime.Now.Year, 7, 31);
            while (date.DayOfWeek != DayOfWeek.Saturday)
            {
                date = date.AddDays(-1);
            }

            for (int i = 0; i < 15; i++)
            {
                MatchDay newMatch = new MatchDay(matchDay, _teamsOne, _teamsTwo, date);
                matchDay++;
                date = date.AddDays(7);
                matchDaysListBox.Items.Add(newMatch);
                SwitchTeams();
            }
            enterScoresOption.IsEnabled = true;
            rankingOption.IsEnabled = true;
        }

        private void EnterScoresOption_Click(object sender, RoutedEventArgs e)
        {

        }

        private void RankingOption_Click(object sender, RoutedEventArgs e)
        {

        }

        private void MatchDaysListBox_MouseDoubleClick(object sender, System.Windows.Input.MouseButtonEventArgs e)
        {
            gamesListBox.Items.Clear();

            MatchDay day = (MatchDay)matchDaysListBox.SelectedItem;
            for (int i = 0; i < 8; i++)
            {
                string line = $"{day.TeamsList1[i].Name} - {day.TeamsList2[i].Name}";
                gamesListBox.Items.Add(line);
            }
        }

        private void GamesListBox_MouseDoubleClick(object sender, System.Windows.Input.MouseButtonEventArgs e)
        {
            Window window = new GameWindow();
            window.Show();
        }
    }
}
