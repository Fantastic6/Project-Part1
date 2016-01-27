/*
 *
 * Name: CPU.java
 * Author: Richard Hsu
 * Overview: This will be the CPU class of the Processor. 
 * It is made up of different functions to handle the different
 * instructions that need to be carried out. (EX: Load/Store...)
 *
*/


import java.util.BitSet;

public class CPU
{
	public static void main(String [] args)
	{
		// declare the different registers that we need

		// 4 general purpose registers (GPRs)
		short[] GPR = new short[4];

		// 3 index registers
		short[] IR = new short[4];

		// 1 instruction register
		short ISR = 0;

		// PC (12 bits - implemented as a bitset)
		BitSet PC = new BitSet(12);

		System.out.println(PC);
		System.out.println("Length: " + PC.length());

		// test example 
		// suppose: instruction is stored at address 4
		PC.set(2);

		System.out.println("Address of Memory: " + PC.toString());


		// memory - Now implemented as an array of 2048 (can change later)
		short[] memory = new short[2048];

		// storing an instruction into index 4
		memory[4] = 1136;

		// storing the data into index 16
		memory[18] = 91;
		memory[17] = 18;

		IR[1] = 1;


		// retrieve the value
		int index = bitSetToInt(PC);
		System.out.println(index);
		
		
		//System.out.println(PC.toString());

		process_instruction(index, ISR, memory, IR, GPR);


	}


	public static void process_instruction(int index, short ISR, short[] memory, short[] IR, short [] GPR)
	{
		// fetch the value that PC is pointing to (an instruction) and move it into IR
		ISR = memory[index];

		System.out.println("Instruction stored at ISR. ISR = " + memory[index]);

		//find the opcode
		int opcode = ISR >> 10;
		System.out.println("opcode is " + opcode);

		// create an array for the parameters
		int [] parameters;

		// parse the instruction at ISR into Opcode, R, IX, I, Address
		parameters = parseInstruction(ISR, opcode);

		// check the parameters array and see that everything is there
		
		for (int i = 0; i < parameters.length; i++)
		{
			System.out.println(parameters[i]);
		}

		
		// use opcode to figure out what instruction to run

		switch(opcode)
		{
			case 1: 
				// call load
				ldr(parameters[1], parameters[2], parameters[3], parameters[4], memory, IR, GPR);
				break;
			default:
				break;
		}



	}


	// converts the address PC is pointing to into an int
	public static int bitSetToInt(BitSet bitSet)
	{
	    int bitInteger = 0;
	    for(int i = 0 ; i < 32; i++)
	        if(bitSet.get(i))
	            bitInteger |= (1 << i);
	    return bitInteger;
	}

	// parse the value stored at that index to turn instruction into a sequence of bits
	public static int [] parseInstruction(short instruction, int opcode)
	{
		int GPRValue = 0;
		int IRValue = 0;
		int IAValue = 0;
		int AddressValue = 0;
		switch(opcode) {
			case 1:
			case 2:
			case 3:
			case 41:
			case 42:
				GPRValue = (instruction & 0x3FF) >> 8;
				IRValue = (instruction & 0xFF) >> 6;
				IAValue = (instruction & 0x3F) >> 5;
				AddressValue = instruction & 0x1F;
				break;
			default:
				break;

		}
		

		int [] parameters = {opcode, GPRValue, IRValue, IAValue, AddressValue};
		return parameters;
	}

	// load instruction
	public static void ldr(int R, int IX, int I, int address, short [] memory, short[] IR, short[] GPR)
	{
		// calculate the effective address
		int EA = getEA(IX, I, address, memory, IR);

		// handle no indirect addressing
		if (I == 0)
		{
			if (IX == 0)
			{
				// load register IX with the contents of the specified address
				GPR[R] = memory[EA];
				System.out.println("Load completed");
				System.out.println(GPR[R]);
			}
			else
			{
				GPR[R] = memory[EA];
				System.out.println("Load completed");
				System.out.println(GPR[R]);
			}
			
		}
		else
		{
			if (IX == 0)
			{
				GPR[R] = memory[EA];
				System.out.println("Load completed");
				System.out.println(GPR[R]);
			}
			else
			{
				GPR[R] = memory[EA];
				System.out.println("Load completed");
				System.out.println(GPR[R]);
			}
		}

	}

	public static void str(int R, int IX, int I, int address, short [] memory, short[] IR, short[] GPR)
	{

	}


	public static int getEA(int IX, int I, int address, short [] memory, short[] IR)
	{
		// handle no indirect addressing
		if (I == 0)
		{
			if (IX == 0)
			{
				// load register IX with the contents of the specified address
				return address;
			}
			else
			{
				return address + IR[IX];
				
			}
			
		}
		else
		{
			if (IX == 0)
			{
				return memory[address];
				
			}
			else
			{
				return memory[address + IR[IX]];
			}
		}
	}

}