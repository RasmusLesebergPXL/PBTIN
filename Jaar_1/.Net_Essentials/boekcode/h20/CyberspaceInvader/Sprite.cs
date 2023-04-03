﻿using System;
using System.Windows.Controls;
using System.Windows.Media.Imaging;

namespace CyberspaceInvader
{
    public abstract class Sprite
    {
        private int _x, _y, _width, _height;

        public int X
        {
            get => _x;
            set { _x = value; UpdateElement(); }
        }
        
        public int Y
        {
            get => _y;
            set { _y = value; UpdateElement(); }
        }

        public int Width
        {
            get => _width;
            set { _width = value; UpdateElement(); }
        }

        public int Height
        {
            get => _height;
            set { _height = value; UpdateElement(); }
        }

        public abstract void DisplayOn(Canvas drawingCanvas);
        protected abstract void UpdateElement();

        protected BitmapImage CreateBitmap(string imagepath)
        {
            var bitmapImage = new BitmapImage();
            bitmapImage.BeginInit();
            bitmapImage.UriSource = new Uri(imagepath,
                                            UriKind.RelativeOrAbsolute);
            bitmapImage.EndInit();
            return bitmapImage;
        }

        protected bool HasHit(Sprite otherSprite)
        {
            if (IsOnTheLeftOf(otherSprite)) return false;
            if (IsOnTheRightOf(otherSprite)) return false;
            if (IsAbove(otherSprite)) return false;
            if (IsBelow(otherSprite)) return false;

            return true;
        }

        private bool IsBelow(Sprite otherSprite)
        {
            return Y > otherSprite.Y + Height;
        }

        private bool IsAbove(Sprite otherSprite)
        {
            return Y + Height < otherSprite.Y;
        }

        private bool IsOnTheRightOf(Sprite otherSprite)
        {
            return X > otherSprite.X + otherSprite.Width;
        }

        private bool IsOnTheLeftOf(Sprite otherSprite)
        {
            return X + Width < otherSprite.X;
        }
    }
}
