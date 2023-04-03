using RecipeBrowser.Models;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace RecipeBrowser.Repositories
{
    public interface IRecipeGroupRepository
    {
        Task<IList<RecipeGroup>> GetAll();
    }
}
