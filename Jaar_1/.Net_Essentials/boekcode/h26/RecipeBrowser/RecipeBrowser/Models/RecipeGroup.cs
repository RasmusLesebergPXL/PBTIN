using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RecipeBrowser.Models
{
    [JsonObject("Group")]
    public class RecipeGroup
    {
        public string UniqueId { get; set; }
        public string Title { get; set; }
        public string Subtitle { get; set; }
        public string Description { get; set; }
        public string ImagePath { get; set; }
        public string GroupImagePath { get; set; }
        public ObservableCollection<Recipe> Items { get; set; }

        public override string ToString()
        {
            return Title;
        }
    }
}
