package mru.tluksa.com.countries;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder> {

    private Countries countries;

    public CountriesAdapter(Countries countries) {
        this.countries = countries;
    }

    @Override
    public int getItemCount() {
        return countries.getGeonames().size();
    }

    @Override
    public void onBindViewHolder(CountriesViewHolder holder, int position) {
        holder.countryName.setText(countries.getGeonames().get(position).getCountryName());
        holder.capitalName.setText(countries.getGeonames().get(position).getCapital());
    }

    @Override
    public CountriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list_item, parent, false);
        return new CountriesViewHolder(view);
    }

    public class CountriesViewHolder extends RecyclerView.ViewHolder {

        TextView countryName;
        TextView capitalName;

        public CountriesViewHolder(View itemView) {
            super(itemView);
            countryName = (TextView) itemView.findViewById(R.id.country_name);
            capitalName = (TextView) itemView.findViewById(R.id.country_capital);
        }
    }
}


