package org.example.mapper;

import org.example.dto.FinnhubStockQuoteDTO;
import org.example.dto.StockQuoteDTO;
import org.example.model.StockQuote;

public class StockQuoteMapper {
    // Convert FinnhubStockQuoteDTO to StockQuoteDTO
    public static StockQuoteDTO toStockQuoteDTO(FinnhubStockQuoteDTO finnhubStockQuoteDTO) {
        StockQuoteDTO stockQuoteDTO = new StockQuoteDTO();
        stockQuoteDTO.setCurrentPrice(finnhubStockQuoteDTO.getCurrentPrice());
        stockQuoteDTO.setChange(finnhubStockQuoteDTO.getChange());
        stockQuoteDTO.setPercentChange(finnhubStockQuoteDTO.getPercentChange());
        stockQuoteDTO.setHighPrice(finnhubStockQuoteDTO.getHighPrice());
        stockQuoteDTO.setLowPrice(finnhubStockQuoteDTO.getLowPrice());
        stockQuoteDTO.setOpenPrice(finnhubStockQuoteDTO.getOpenPrice());
        stockQuoteDTO.setPreviousClosePrice(finnhubStockQuoteDTO.getPreviousClosePrice());
        stockQuoteDTO.setTimestamp(finnhubStockQuoteDTO.getTimestamp()); // Use current timestamp or another logic
        return stockQuoteDTO;
    }

    // Convert StockQuoteDTO to StockQuote entity
    public static StockQuote toStockQuote(StockQuoteDTO stockQuoteDTO, String symbol) {
        StockQuote stockQuote = new StockQuote();
        stockQuote.setCurrentPrice(stockQuoteDTO.getCurrentPrice());
        stockQuote.setChange(stockQuoteDTO.getChange());
        stockQuote.setPercentChange(stockQuoteDTO.getPercentChange());
        stockQuote.setHighPrice(stockQuoteDTO.getHighPrice());
        stockQuote.setLowPrice(stockQuoteDTO.getLowPrice());
        stockQuote.setOpenPrice(stockQuoteDTO.getOpenPrice());
        stockQuote.setPreviousClosePrice(stockQuoteDTO.getPreviousClosePrice());
        stockQuote.setTimestamp(stockQuoteDTO.getTimestamp());
        return stockQuote;
    }
}
