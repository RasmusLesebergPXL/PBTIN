using System;
using System.Windows.Controls;

namespace Exercise2
{
    public class BlackBoard : IBlackBoard
    {
        public void SubscribeToStudentAdministrationEvents(IStudentAdministration administration, TextBlock outputTextBlock)
        {
            StudentAdministration admin = (StudentAdministration)administration;
            admin.StudentTotal += 1;
        }
    }
}
