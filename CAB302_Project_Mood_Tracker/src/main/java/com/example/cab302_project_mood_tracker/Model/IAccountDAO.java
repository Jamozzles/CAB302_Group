package com.example.cab302_project_mood_tracker.Model;

import java.util.List;

public interface IAccountDAO {

    public void addAccount(Account account);

    public void updateAccount(Account account);

    public void deleteAccount(Account account);

    public Account getAccount(int id);

    public List<Account> getAllAccounts();
}