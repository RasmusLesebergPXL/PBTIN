using System;
using System.IO;

namespace PixelPass
{
    public class AccountInfoCollectionReader
    {
        public static IAccountInfoCollection Read(string filename)
        {
            AccountInfoCollection newCollection;
            string[] lines;

            string folderPath = Environment.GetFolderPath(
                                   Environment.SpecialFolder.Desktop);
            string filePath = System.IO.Path.Combine(folderPath, filename);
            using StreamReader reader = File.OpenText(filePath);
            string line = reader.ReadLine();

            if (line.Substring(0, 6) == "Name: ")
            {
                newCollection = new AccountInfoCollection(line.Substring(6).Trim());
                line = reader.ReadLine();

                while (line != null)
                {
                    lines = line.Split(',');
                    AccountInfo account = new AccountInfo();

                    account.Title = lines[0];
                    account.Username = lines[1];
                    account.Password = lines[2];
                    account.Notes = lines[3];
                    account.Expiration = Convert.ToDateTime(lines[4]);

                    newCollection.AccountInfos.Add(account);
                    line = reader.ReadLine();
                }
            }
            else
            {
                throw new ParseException(" does not start with 'Name':");
            }
            reader?.Close();
            return newCollection;
        }
    }
}
