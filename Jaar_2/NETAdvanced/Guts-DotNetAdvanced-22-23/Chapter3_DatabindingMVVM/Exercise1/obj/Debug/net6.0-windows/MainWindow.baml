   M S B A M L   `   `   `  ����D  @Exercise1, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null%clr-namespace:Exercise1	Exercise1  5   	       Exercise1.MainWindow   5   	   W SPresentationCore, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   )localclr-namespace:Exercise1     5   	     � Title$  Movies��5   	   $	��700��6   $	��600��6%   .��5	      �  � RowDefinitions 5
   
   �� 5      6   �� 5      $
��Auto �6   6,   .+�5   
   �� $��
All movies��6   $��10q�6'   .��5      �� -   5         ��Name$ MoviesListView��5      $��10q�6^   ��6/   ��  �� Path$ MovieCollection� �� View 5      �� 5       �� ColumnHeaderToolTip$ Movie Information��6   .P�5      �� $��Title��6U    �� DisplayMemberBinding 6)   �� $ Title�6U   �� 5      $��Director��6X    6)   �� $ Director�6X   �� 5      $��Release year��6[    6)   �� $ ReleaseYear�6[   5      5      5      �� 5   
   -   5         ��Name$ NewMovieGroupBox��5      $��Add a new movie��6-   $��1��6F   $��10q�6S    � DataContext 5         Exercise1.Movie  5      .��5      � .+�5      �� -   5        	 ��Name$	 
TitleLabel��5      $��_Title��6,   $
��Left=�6=   $��	10,10,0,0q�6X   $	��Top=�6k   
 �� Target
 5      ��  �� ElementName$ TitleTextBox�� �� Mode$ OneWay=��� 5       -   5         ��Name$ TitleTextBox��5       $
��Left=�60   $	��Top=�6K   $	��150��5!      $��25��6*   $��
100,10,0,0q�66   ��6J   �� $ Title��� 5#      -   5        $	 DirectorLabel��5#      $��	_Director��6/   $
��Left=�6C   $��	10,50,0,0q�6^   $	��Top=�6q   
 5$      �� $ DirectorTextBox��$ OneWay=��� 5%      -   5        $ DirectorTextBox��5%      $
��Left=�63   $	��Top=�6O   $	��150��5&      $��25��6*   $��
100,50,0,0q�66   ��6J   �� $ Director��� 5(      -   5        $	 ReleaseYearLabel��5(      $��_Release year��62   $
��Left=�6J   $��	10,90,0,0q�6e   $	��Top=�6x   
 5)      �� $ ReleaseYearTextBox��$ OneWay=��� 5*      -   5        $ ReleaseYearTextBox��5*      $
��Left=�66   $	��Top=�6R   $	��150��5+      $��25��6&   $��
100,90,0,0q�62   ��6F   �� $ ReleaseYear��� 5-      -	   5         ��Name$ AddNewMovieButton��5-      $
��Left=�64   $��10,140,10,10q�6O   $	��Top=�6e   .��6�   	Add Movie6�   �� 5.      -
   5         ��Name$ ErrorMessageTextBlock��5.      $
��Left=�6;   $��100,140,10,10q�6V   $	��Top=�6m   
���  ��$��14(�5/   1   6A   50      51      52      53      