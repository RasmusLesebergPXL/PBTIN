using System.ComponentModel;
using System.Runtime.CompilerServices;

namespace Exercise2.Model
{
    public class Movie : INotifyPropertyChanged
    {
        private int _rating;
        public Movie()
        {
            Title = string.Empty;
            OpeningCrawl = string.Empty;
            Rating = 1;
        }
        public string Title { get; set; }
        public string OpeningCrawl { get; set; }
        public int Rating { get { return _rating; }
            set
            {
                if (_rating != value)
                {
                    _rating = value;
                    if (value < 1)
                    {
                        _rating = 1;
                    } else if (value > 5)
                    {
                        _rating = 5;
                    }
                    OnPropertyChanged();
                }
            }
        }

        public event PropertyChangedEventHandler? PropertyChanged;

        protected void OnPropertyChanged([CallerMemberName] string? name = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
        }
    }
}
