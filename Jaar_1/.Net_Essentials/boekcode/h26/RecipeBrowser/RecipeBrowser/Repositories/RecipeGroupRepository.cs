using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Newtonsoft.Json;
using RecipeBrowser.Models;
using Windows.Storage;

namespace RecipeBrowser.Repositories
{
    public class RecipeGroupRepository : IRecipeGroupRepository
    {
        private static string _baseUri = "ms-appx:///Repositories/RecipeData.json"; // Default base URI

        public async Task<IList<RecipeGroup>> GetAll()
        {
            IList<RecipeGroup> groups = null;
            Uri fileUri = new Uri(_baseUri);
            StorageFile file = await StorageFile.GetFileFromApplicationUriAsync(fileUri);
            string jsonText = await FileIO.ReadTextAsync(file);

            groups = JsonConvert.DeserializeObject<RecipeBook>(jsonText).Groups;

            return groups;
        }
    }
}
