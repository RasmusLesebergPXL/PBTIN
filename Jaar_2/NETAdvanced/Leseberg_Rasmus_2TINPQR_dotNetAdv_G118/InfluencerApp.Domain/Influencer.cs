namespace InfluencerApp.Domain
{
    public class Influencer
    {
        private string? _name;
        public int Id { get; set; }
        public string? Name
        {
            get => _name;
            set
            {
                if (value != null && value.Length > 100)
                {
                    throw new ArgumentException("The name is too long");
                }
                _name = value;
            }
        }
        public string? Description { get; set; }
        public IList<Video>? Videos { get; set; }
    }
}