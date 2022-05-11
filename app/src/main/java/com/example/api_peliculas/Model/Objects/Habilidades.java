package com.example.api_peliculas.Model.Objects;

import com.example.api_peliculas.Model.Objects.AbilityObject;

public class Habilidades {

    private String is_hidden;
    private String slot;
    private AbilityObject ability;

    public String getIs_hidden() {
        return is_hidden;
    }

    public void setIs_hidden(String is_hidden) {
        this.is_hidden = is_hidden;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public AbilityObject getAbility() {
        return ability;
    }

    public void setAbility(AbilityObject ability) {
        this.ability = ability;
    }
}

