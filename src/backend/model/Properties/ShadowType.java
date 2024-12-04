package backend.model.Properties;

import backend.model.figures.Figure;

public enum ShadowType {
    NONE,
    SIMPLE {
        @Override
        public abstract drawShadow(){
            Figure shadow = new ();
        }
    },
    COLORED {
        @Override
        public abstract drawShadow(){

        }
    },
    SIMPLE_INVERSE {
        @Override
        public abstract drawShadow(){

        }
    },
    COLORED_INVERSE {
        @Override
        public abstract drawShadow(){

        }
    };

    public abstract drawShadow();
}
