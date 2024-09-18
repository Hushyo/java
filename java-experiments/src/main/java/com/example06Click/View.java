package com.example06Click;
public class View {
        private Click click;
        public void setClick(Click click) {
            this.click = click;
        }
        public void click() {
            if (click != null) {
                click.onClick();
            }
        }
    }