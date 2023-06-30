using System;
using System.Windows;

namespace Exercise2
{
    public partial class MainWindow : Window
    {
        public MainWindow(IStudentAdministration administration, IBlackBoard blackBoard)
        {
            InitializeComponent();
            blackBoard.SubscribeToStudentAdministrationEvents(administration, blackBoardTextBlock);

        }
        private void addStudentButton_Click(object sender, RoutedEventArgs e)
        {
            Student student = new(firstNameTextBox.Text.ToString(), lastNameTextBox.Text.ToString(),
                                   departmentTextBox?.Text.ToString());

            blackBoardTextBlock.Inlines.Add("Student added:\n");
            blackBoardTextBlock.Inlines.Add(student.ToString() + "\n");
        }
    }
}
