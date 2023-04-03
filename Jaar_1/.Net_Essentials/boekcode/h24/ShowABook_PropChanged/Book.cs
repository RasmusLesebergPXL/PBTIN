using System.ComponentModel;

namespace ShowABook_PropChanged
{
    public class Book : INotifyPropertyChanged
    {
        public long ISBN { get; set; }

        private string _title;
        public string Title
        {
            get => _title;
            set
            {
                if (_title != value)
                {
                    _title = value;
                    if (PropertyChanged != null)
                        PropertyChanged(this, 
                         new PropertyChangedEventArgs(nameof(Title)));
                }
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;
    }
}
