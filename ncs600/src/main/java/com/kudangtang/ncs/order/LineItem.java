package com.kudangtang.ncs.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class LineItem {
	private MenuItem menuItem;
	private int quantity;
}
