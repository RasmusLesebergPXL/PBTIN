   M S B A M L   `   `   `  ����D  @Exercise1, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null%clr-namespace:Exercise1	Exercise1  5   	       Exercise1.MainWindow   5   	   W SPresentationCore, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   )localclr-namespace:Exercise1     5   	     � Title$  	Exercise1��5   	   $	��450��6   $	��800��6(   .��5	      �  � ShowGridLines$
 True��6    � RowDefinitions 5
   
   �� 5      $
��Auto �6   �� 5      $��2* �6   �� 5      $��5* �6   �� 5      $
��Auto �6    � ColumnDefinitions 5   
   �� 5      �� 5      �� 5      .+�5   
   �� $��Code breaker��6   $
��Bold"�6(   $��25(�6:   $��Center=�6H   $��Center=�6e   $��3��5      $��0��6(   $��5q�65   �� 5   
   -   5        $��key1Textbox��5   *   $��1��5      $��0��6   $��Center=�6/   $��Center=�6L   $	��100��5      $��20��6   6*   G� 5   
   -   5        $��key2Passwordbox��5   *   $��1��5      $��1��6#   $��Center=�63   $��Center=�6P   $	��100��5      $��20��6   6*   �� 5   
   -   5        $��key3Checkbox��5   *   $��1��5      $��2��6    $��Center=�60   $��Center=�6M   $	��100��5      $��20��6   6*   �� 5   
   $��1��6   $��2��6   $
��Key3��6-   $��Center=�6<   $��Center=�5      $��15(�6+   $��0 0 30 5q�69   �� 5   
   -   5        $��key4Combobox��5    .   $��2��5      $��0��6    $��Center=�60   $��Center=�6K   $
��Auto��5       $
��Auto��6    .@�5!      �� .��6   Item 16#   �� 5"      .��6   Item 26#   �� 5#      .��6   Item 36#   5$      �� 5%   
   $��2��6   $��1��6    $��Center=�60   $��Center=�5&      $
��Auto��6.   $
��Auto��6;   $
��Key5��5'      .��5(      �� .@�5)      	�  d� 	IsChecked$
 TrueY�6   .��6/   Item 167   	� 5*      -   5        $��key5RadioButton��5*      .��65   Item 26=   	� 5+      .��6   Item 36&   5,      5-      �� 5.   
   -   5        $��breakButton��5/      $��2��5.      $��2��6   $��8 8 8 8q�6.   
�������.��50      ��  �� Orientation$ Vertical=�6   $��2��60   $��2��6=   $��Center=�6M   .+�51      �� $��2��6   $��2��6)   $��Center=�6:   $��Center=�6W   $2��,Fill in the correct values to break the code��52      �� 53      $��2��6   $��2��6)   $��Center=�69   $��Center=�6V   $��	Break it!��54      $��20(�6%   $
��Bold"�63   55      56      �� 57   
   -   5        $��messageBorder��58   J   $��3��57      $��3��6%   
������� �� CornerRadius$ 20��58      $�� 20 10q�6#   $y�	Collapsed=�63   ._�59      �� -   5        $��messageTextBlock��5;   8   $��You cracked the code!!��59       �� TextAlignment$ Center=�66   $��Center=�5:      $��Center=�65   $��25(�5;      $
��Bold"�6&   68   5<      5=      5>      