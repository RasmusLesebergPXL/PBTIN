using System.Text;

namespace Exercise1
{
    public class Composition
    {
        public Composition()
        {
            Title = string.Empty;
            Description = string.Empty;
            ReleaseDate = DateTime.MinValue;
            Composer = null;
        }
        public string Title { get; set; }
        public string Description { get; set; }
        public string? Composer { get; set; }
        public DateTime ReleaseDate { get; set; }

        public override string ToString()
        {
            StringBuilder builder = new();

            builder.Append($"Title: {Title}\r\n");
            builder.Append($"Description: {Description}\r\n");
            builder.Append($"Composer: {(string.IsNullOrEmpty(Composer) ? "/" : Composer)}\r\n");
            builder.Append($"Release: {ReleaseDate.ToString("dd/MM/yyyy")}");
            builder.Append($" -  {ReleaseDate.ToCentury()}° Century");

            return builder.ToString();
        }
    }
}
