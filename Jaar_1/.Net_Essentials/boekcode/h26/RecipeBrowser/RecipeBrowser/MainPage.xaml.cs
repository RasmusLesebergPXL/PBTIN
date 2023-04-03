using RecipeBrowser.Models;
using RecipeBrowser.Repositories;
using System.Collections.Generic;
using Windows.UI.Xaml.Controls;

// The Blank Page item template is documented at https://go.microsoft.com/fwlink/?LinkId=402352&clcid=0x409

namespace RecipeBrowser
{
    /// <summary>
    /// An empty page that can be used on its own or navigated to within a Frame.
    /// </summary>
    public sealed partial class MainPage : Page
    {
        private IEnumerable<RecipeGroup> groups;
        private IRecipeGroupRepository repository;

        public MainPage()
        {
            this.InitializeComponent();
            LoadGroups();

            groupsList.SelectionChanged += groupsList_SelectionChanged;
        }

        void groupsList_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            RecipeGroup group = (RecipeGroup)groupsList.SelectedValue;
            recipeList.ItemsSource = group.Items;
        }

        private async void LoadGroups()
        {
            repository = new RecipeGroupRepository();
            groups = await repository.GetAll();
            groupsList.ItemsSource = groups;
        }
    }
}
