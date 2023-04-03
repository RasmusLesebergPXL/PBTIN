using System.Collections.Generic;

namespace PixelPass
{
    public class AccountInfoCollection : IAccountInfoCollection
    {
        public string Name { get; set; }

        public List<AccountInfo> AccountInfos { get; }

        public AccountInfoCollection(string naam)
        {
            AccountInfos = new List<AccountInfo>();
            Name = naam;
        }
    }
}
