using System;
using System.Collections.Generic;
using System.IO;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Threading;

namespace Game
{
    public partial class GameWindow : Window
    {
        private Animal _currentAnimal;  // the choosen animal

        private List<int> _choosenList = new List<int>();// used to generate a Location
        private Random _random = new Random(); // used to generate a location
        private int _countColumns; // number of columns of the AnimalWorld
        private int _countRows; // number of rows of the AnimalWorld
        private AnimalWorld _animalWorld;
        private string _name; // the name of the player
        private int _amountOfFood; // the right amount of food
        private TimeSpan _time; // the time the player has left to play the game
        private DispatcherTimer _timer = new DispatcherTimer();
        private string _file;
        private string _food;


        //ToDo change the signature of the constructor
        public GameWindow(int coloumns, int rows, string animal, string name)
        {
            InitializeComponent();
            _countColumns = coloumns;
            _countRows = rows;
            _name = name;
            
            // ToDo choose the right animal from the list _allAnimals                   DONE
            Animal[] _allAnimals = { new Squirrel(), new Hedgehog(), new Rabbit() };

            if (animal == "eekhoorn")
            {
                _currentAnimal = _allAnimals[0];
            } else if (animal == "egel")
            {
                _currentAnimal = _allAnimals[1];
            } else if (animal == "konijn")
            {
                _currentAnimal = _allAnimals[2];
            }

            // ToDo calculate the right amount of food                                  DONE
            _amountOfFood = _countRows * _countColumns / 10;

            CreateWorld(); // implement this method                                     DONE
            // ToDo set the Title of the window                                         DONE
                        
            this.Title = $"speler {name}";
            
            // ToDo calculate the total time the player has, to play the game           DONE

            _timer.Interval = TimeSpan.FromSeconds(1);
            _timer.Tick += _Timer_Tick;
            int time = _amountOfFood * 2;
            _time = new TimeSpan(0, 0, time);
            timeTextBox.Text = $"{_time.Seconds} seconden";
        }

        private void _Timer_Tick(object sender, EventArgs e)
        {
            timeTextBox.Text = $"{_time.Seconds} seconden";
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            // ToDo according to the button you clicked on => one step to the right, to the left, one step up, one step down    DONE

            var clickedOperand = (Button)sender;
            
            if (clickedOperand.Equals(upButton))
            {
                _animalWorld.Move(_currentAnimal, 0, 1);
            } else if (clickedOperand.Equals(downButton))
            {
                _animalWorld.Move(_currentAnimal, 0, -1);
            } else if (clickedOperand.Equals(leftButton))
            {
                _animalWorld.Move(_currentAnimal, -1, 0);
            } else if (clickedOperand.Equals(rightButton))
            {
                _animalWorld.Move(_currentAnimal, 1, 0);
            }
            // ToDo check after you moved your player if there remains food => if not player wins and game is over

            if (_animalWorld.FoodCount == 0)
            {
                MessageBoxResult result = MessageBox.Show($"{_currentAnimal} {_name} heeft zijn voedsel gevonden", "Gewonnen", MessageBoxButton.OKCancel, MessageBoxImage.Warning);
                _timer.Stop();
                
                if (result == MessageBoxResult.OK)
                {
                    StreamWriter writer = null;
                    try
                    {
                        string folderPath = Environment.GetFolderPath(
                                    Environment.SpecialFolder.Desktop);
                        // Append content
                        if (_currentAnimal is Squirrel)
                        {
                            _file = System.IO.Path.Combine(folderPath,
                                                                    "squirrel.txt");
                            _food = "acorns";
                        } else if (_currentAnimal is Hedgehog)
                        {
                            _file = System.IO.Path.Combine(folderPath,
                                                                    "hedgehog.txt");
                            _food = "earthworms";
                           
                        } else if (_currentAnimal is Rabbit)
                        {
                            _file = System.IO.Path.Combine(folderPath,
                                                                    "rabbit.txt");
                            _food = "carrots";
                        }
                        FileStream fstream = new FileStream(_file,
                                                            FileMode.Append,
                                                            FileAccess.Write);
                        writer = new StreamWriter(fstream);
                        writer.Write($"{_currentAnimal} {_name} has found all {_food} on {DateTime.Now}");
                    }
                    catch (IOException ex)
                    {
                        MessageBox.Show(ex.Message);
                    }
                    finally
                    {
                        if (writer != null)
                        {
                            writer.Close();
                        }
                    }
                } else
                {
                    this.Close();
                }
            } else if (_animalWorld.FoodCount != 0 && _time.TotalSeconds <= 0)
            {
                MessageBox.Show($"{_currentAnimal} {_name}: Je hebt niet alle voedsel gevonden");
            }
        }

        private int GenerateLocation()
        {
            int number = _random.Next(_countRows * _countColumns);
            while (_choosenList.Contains(number))
            {
                number = _random.Next(_countRows * _countColumns);
            }
            return number;
        }

        private void PlaceFoodOnBoard()
        {
            for (int i = 0; i < _amountOfFood; i++)
            {
                int number = GenerateLocation();
                Food food = new Food(_currentAnimal.Species);
                _animalWorld.AddSpriteToWorld(food, number % _countColumns, number / _countColumns);
            }
        }

        private void CreateWorld()
        {
            //ToDo Make an AnimalWorld. Don't forget to give the property FoodCount the correct value.    DONE

            _animalWorld = new AnimalWorld(gameCanvas, _countRows, _countColumns);
            _animalWorld.AddSpriteToWorld(_currentAnimal, _countRows, _countColumns);
            _animalWorld.FoodCount = _amountOfFood;
            PlaceAnimalOnBoard();
            PlaceFoodOnBoard();
        }

        private void EnableButtons()
        {
            leftButton.IsEnabled = true;
            rightButton.IsEnabled = true;
            upButton.IsEnabled = true;
            downButton.IsEnabled = true;
        }

        private void PlaceAnimalOnBoard()
        {
             int number = GenerateLocation();
            _animalWorld.AddSpriteToWorld(_currentAnimal, number % _countColumns, number / _countColumns);
        }

        private void StartButton_Click(object sender, RoutedEventArgs e)
        {
            _timer.Start();
            EnableButtons();
        }
    }
}
