package net.tomo.tvdependencyinjection;

public class CatPetService implements PetService
{
    @Override
    public String getPetType()
    {
        return "CatPetService - getPetType()";
    }
}
