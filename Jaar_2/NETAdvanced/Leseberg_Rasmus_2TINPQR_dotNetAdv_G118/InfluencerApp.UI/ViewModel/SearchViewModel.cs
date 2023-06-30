using System;
using System.Collections.ObjectModel;
using System.Runtime.CompilerServices;
using System.Windows;
using InfluencerApp.AppLogic;
using InfluencerApp.UI.Command;

namespace InfluencerApp.UI.ViewModel;

public class SearchViewModel : ViewModelBase
{
    private IInfluencerService _service;
    private ObservableCollection<InfluencerSummary> _influencers;
    public SearchViewModel(IInfluencerService influencerService)
    {
        _service = influencerService;
        Influencers = new ObservableCollection<InfluencerSummary>();
        _influencers = Influencers;
        SearchInfluencers = new DelegateCommand(SearchForInfluencers);

        SearchTerm = "";
        AmountOfVideos = "0";
    }

    public ObservableCollection<InfluencerSummary> Influencers 
    {
        get => _influencers;
        set
        {
            _influencers = value;
            OnPropertyChanged(nameof(Influencers));
        }
    }

    public string? AmountOfVideos { get; set; }

    public string? SearchTerm { get; set; }

    public DelegateCommand SearchInfluencers { get; }

    private void SearchForInfluencers(object? sender)
    {
        Influencers.Clear();
        if (SearchTerm != null && AmountOfVideos != null)
        {
            int videos = int.Parse(AmountOfVideos);
            _influencers = new ObservableCollection<InfluencerSummary>(_service.Find(SearchTerm, videos));
        }
    }

    protected override void OnPropertyChanged([CallerMemberName] string? propertyName = null)
    {
        base.OnPropertyChanged(propertyName);
    }

}