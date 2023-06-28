using System;
using System.IO;
using System.Windows;
using System.Windows.Input;

namespace DominationGame
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private Board _board;
        private Player _currentPlayer = Player.Red;
        private Player _nextPlayer = Player.Blue;
        private bool _gameStarted = false;
        private int _xCoord;
        private int _yCoord;
        public MainWindow()
        {
            InitializeComponent();

            _board = new Board(8,8);
            _board.DrawBoard(paperCanvas);
        }

        //Mouse movement X,Y Tracer
        private void Canvas_MouseMove(object sender, MouseEventArgs e)
        {
            _xCoord = Convert.ToInt32(e.GetPosition(paperCanvas).X);
            _yCoord = Convert.ToInt32(e.GetPosition(paperCanvas).Y);
            xCoordTextBlock.Text = "X-Coordinate: " + _xCoord;
            yCoordTextBlock.Text = "Y-Coordinate: " + _yCoord;
        }

        //Click on specific block
        private void Canvas_MouseDown(object sender, MouseButtonEventArgs e)
        {
            if (_gameStarted == true)
            {
                selectedBlockLabel.Content = $"({_xCoord / 45},{_yCoord / 45})";

                try
                {
                    _board.ClaimBlocks(_yCoord / 45, _xCoord / 45, _currentPlayer);
                    if (_currentPlayer == Player.Red)
                    {
                        turnLabel.Content = "Blue player's turn";
                    }
                    else
                    {
                        turnLabel.Content = "Red player's turn";
                    }
                    WriteText();
                    (_currentPlayer, _nextPlayer) = (_nextPlayer, _currentPlayer);
                } 
                catch (DominationException error)
                {
                    MessageBox.Show(error.Message);
                }         
            }
            else
            {
                MessageBox.Show("Game has not started yet, clik Start Game to start");
            }
        }

        private void WriteText()
        {
            StreamWriter writer = null;
            
            try
            {
                string folderPath = Environment.GetFolderPath(
                                      Environment.SpecialFolder.MyDocuments);
                string filePath = System.IO.Path.Combine(
                                            folderPath, "domination.txt");
                FileStream fstream = new FileStream(filePath,
                                                    FileMode.Append,
                                                    FileAccess.Write);
                writer = new StreamWriter(fstream);

                if (_currentPlayer == Player.Red)
                {
                    writer.WriteLine($"Red Player ({_xCoord / 45},{_yCoord / 45}) ({_xCoord / 45 + 1},{_yCoord / 45})");
                }
                else if (_currentPlayer == Player.Blue)
                {
                    writer.WriteLine($"Blue Player ({_xCoord / 45},{_yCoord / 45}) ({_xCoord / 45},{_yCoord / 45 + 1})");
                }
            }
            finally
            {
                writer?.Close();
            }
        }

        private void StartGame_Click(object sender, RoutedEventArgs e)
        {
            _gameStarted = true;
            turnLabel.Content = "Red Player's turn";
        }

        private void Moves_Click(object sender, RoutedEventArgs e)
        {
            //if (_gameStarted == false)
            //{
                Window window = new Moves();
                window.Show();
            //}
            //else
            //{
            //    MessageBox.Show("Game is not finished yet");
            //}
        }

        private void Exit_Click(object sender, RoutedEventArgs e)
        {
            Environment.Exit(0);
        }
    }
}
