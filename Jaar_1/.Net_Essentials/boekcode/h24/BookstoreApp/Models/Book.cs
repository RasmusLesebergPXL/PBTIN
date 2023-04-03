using System;
using System.ComponentModel;

namespace BookstoreApp.Models
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
                    RaisePropertyChanged(nameof(Title));
                }       
            }
        }

        public string ShortDescription { get; set; }
        public Author MainAuthor { get; set; }
        public int PageCount { get; set; }
        public DateTime PublicationDate { get; set; }
        public double Price { get; set; }

        public event PropertyChangedEventHandler PropertyChanged;

        private void RaisePropertyChanged(string propname)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged(this,
                 new PropertyChangedEventArgs(propname));
            }
        }
    }
}
